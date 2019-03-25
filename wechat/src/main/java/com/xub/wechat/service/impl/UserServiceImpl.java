package com.xub.wechat.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xub.wechat.enums.AccountStatusEnum;
import com.xub.wechat.enums.DeleteStatusEnum;
import com.xub.wechat.enums.SearchFriendsStatusEnum;
import com.xub.wechat.mapper.MyFriendsMapper;
import com.xub.wechat.mapper.UserMapper;
import com.xub.wechat.pojo.MyFriends;
import com.xub.wechat.pojo.User;
import com.xub.wechat.pojo.bo.ReturnResult;
import com.xub.wechat.service.UserService;
import com.xub.wechat.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;


/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author lqx
 * @Date 2019/3/10.14:03
 **/
@Service("userService")
public class UserServiceImpl implements UserService {


    @Value("${temp.basePath}")
    private String basePath;

    @Value("${temp.qrcodeFileName}")
    private String qrcodeFileName;

    @Value("${temp.qrcodePrefix}")
    private String qrcodePrefix;

    @Value("${temp.defaultAvatar}")
    private String defaultAvatar;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MyFriendsMapper myFriendsMapper;

    @Autowired
    private QRCodeUtils qrCodeUtils;

    @Autowired
    private FastDFSClient fastDFSClient;


    /*
     * 注册
     * */
    @Override
    public ResponseData register(User user, HttpServletRequest request) {
        String address = "";
        if (!queryUsernameIsExist(user.getUsername())) {

            String salt = StringUtil.getRandomString();
            //盐值
            String userid = salt.substring(10, 30);
            //加密后的字符串
            String encodeStr = DigestUtils.md5DigestAsHex((user.getPwd() + salt).getBytes());
            user.setUserid(userid);
            user.setNickname(user.getUsername());

            user.setSalt(salt);
            user.setPwd(encodeStr);
            user.setStatus(AccountStatusEnum.NORMAL.getCode());//可用
            user.setIsDel(DeleteStatusEnum.NOT_DELETE.getCode());//账户正常
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            //默认头像
            user.setAvatarUrl(defaultAvatar);
            user.setAvatarUrlBig(defaultAvatar);

            // 为每个用户生成一个唯一的二维码
            String qrCodePath = basePath + userid + qrcodeFileName;
            //为每一个用户生成一个唯一的二维码 wechat_qrcode:[username]
            qrCodeUtils.createQRCode(qrCodePath, qrcodePrefix + ":" + user.getUsername());
            MultipartFile qrCodeFile = FileUtils.fileToMultipart(qrCodePath);

            String qrCodeUrl = "";
            try {
                qrCodeUrl = fastDFSClient.uploadQRCode(qrCodeFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            user.setQrcode(qrCodeUrl);

            //获取用户的地址信息
                /*address = AddressUtil.getAddresses("ip="+HttpUtil.getIpAddress(request), "utf-8");
                if(address!=null&&!address.equals("0")){
                    ReturnResult returnResult = JSONObject.parseObject(address, ReturnResult.class);
                    user.setCountry(returnResult.getData().getCountry());
                    user.setRegion(returnResult.getData().getRegion());
                    user.setCity(returnResult.getData().getCity());
                }*/
            int flag = userMapper.insertSelective(user);
            if (flag > 0) {
                return ResponseData.ok("注册成功");
            } else {
                return ResponseData.error("注册失败");
            }

        }
        return ResponseData.error("用户名已存在");

    }


    /*
     * 登录
     * */
    @Override
    public ResponseData login(String username, String pwd) {
        User user = new User();
        user.setUsername(username);
        User result = userMapper.selectOne(user);
        if (result == null) {
            //用户名不存在
            return ResponseData.error("用户名不存在！");
        } else if (result.getStatus() == AccountStatusEnum.LOCKED.getCode()) {
            //账号锁定
            return ResponseData.error("账户已被锁定！");
        } else if (!result.getPwd().equals(DigestUtils.md5DigestAsHex((pwd + result.getSalt()).getBytes()))) {
            //密码错误
            return ResponseData.error("密码错误！");
        } else {
            return ResponseData.ok("登录成功！").putDataValue("user", result);
        }
    }


    /*
     * 判断用户名是否存在
     * */
    @Override
    public boolean queryUsernameIsExist(String username) {
        User user = new User();
        user.setUsername(username);
        User result = userMapper.selectOne(user);
        return result != null ? true : false;
    }


    /**
     * @Description: 修改用户记录
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public User updateUserInfo(User user) {
        userMapper.updateByPrimaryKeySelective(user);
        return queryUserById(user.getUserid());
    }


    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public User queryUserById(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    /*
     * 更新用户信息（昵称）
     * */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public ResponseData upadteUserById(User user) {
        if (userMapper.updateByPrimaryKeySelective(user) > 0) {
            User result = queryUserById(user.getUserid());
            if (result != null) {
                return ResponseData.ok("更新成功").putDataValue("user", result);
            }
        }
        return ResponseData.error("更新失败");
    }

    /*
     * 根据用户名查找
     * */
    public ResponseData search(String username) {
        List<User> users = userMapper.search(username);
        if (users.size() > 0) {
            return ResponseData.ok("查找成功").putDataValue("users", users);
        }
        return ResponseData.error("用户不存在");
    }

    @Override
    public User queryUserInfoByUsername(String username) {
        return userMapper.queryUserInfoByUsername(username);
    }

    @Override
    public Integer preConditionSearchFriend(String myUserid, String friendUsername) {

        //1、搜索的用户不存在，返回：无此用户
        User search_result = queryUserInfoByUsername(friendUsername);
        if (StringUtil.isEmpty(search_result)) {
            return SearchFriendsStatusEnum.USER_NOT_EXIST.code;
        }
        //2、搜索的用户是自己，返回：不能添加自己
        if (search_result.getUserid().equals(myUserid)) {
            return SearchFriendsStatusEnum.NOT_YOURSELF.code;
        }
        //3、搜索的用户已经是你的好友，返回：该用户已经是你的好友
        MyFriends myFriends = new MyFriends();
        myFriends.setFriendId(search_result.getUserid());
        myFriends.setMineId(myUserid);
        MyFriends relationship = myFriendsMapper.selectOne(myFriends);
        if (!StringUtil.isEmpty(relationship)) {
            return SearchFriendsStatusEnum.ALREADY_FRIENDS.code;
        }
        return SearchFriendsStatusEnum.SUCCESS.code;
    }


}
