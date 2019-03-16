package com.xub.wechat.service.impl;

import com.xub.wechat.enums.DeleteStatusEnum;
import com.xub.wechat.enums.OperatorFriendRequestTypeEnum;
import com.xub.wechat.enums.RequestStatusEnum;
import com.xub.wechat.mapper.FriendRequestMapper;
import com.xub.wechat.mapper.MyFriendsMapper;
import com.xub.wechat.pojo.FriendRequest;
import com.xub.wechat.pojo.MyFriends;
import com.xub.wechat.pojo.vo.FriendRequestVO;
import com.xub.wechat.pojo.vo.MyFriendsVO;
import com.xub.wechat.service.FriendRequestService;
import com.xub.wechat.utils.ResponseData;
import com.xub.wechat.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @ClassName FriendRequestServiceImpl
 * @Description TODO
 * @Author lqx
 * @Date 2019/3/12.10:43
 **/
@Service("friendRequestService")
public class FriendRequestServiceImpl implements FriendRequestService {

    @Autowired
    private FriendRequestMapper friendRequestMapper;

    @Autowired
    private MyFriendsMapper myFriendsMapper;


    /*
    * 发送好友请求
    * */
    @Override
    public ResponseData sendFriendRequest(FriendRequest friendRequest) {
        //查询用户有没有发送过请求
        FriendRequest search=friendRequestMapper.selectOne(friendRequest);
        if(StringUtil.isEmpty(search)){
            String requestId= StringUtil.getRandomString();
            friendRequest.setRequestId(requestId);
            friendRequest.setStatus(RequestStatusEnum.Wait_Accept.getCode());
            friendRequest.setRequestTime(new Date());
            int flag=friendRequestMapper.insert(friendRequest);
            if(flag>0){
                return ResponseData.ok("发送好友请求成功");
            }
        }
        return ResponseData.error("已发送请求，请勿重复发送");
    }


    /*
     * 获取好友请求列表
     * */
    @Override
    public ResponseData getFriendRequestList(String acceptUserId) {
        List<FriendRequestVO> friendRequestVOS=friendRequestMapper.getFriendRequestList(acceptUserId);
        if (friendRequestVOS.size() != 0) {
            return ResponseData.ok("查询好友请求成功").putDataValue("friendRequests",friendRequestVOS);
        }
        return ResponseData.error("没有请求列表");
    }



    /**
     * @Description: 接受方 通过或者忽略、拒绝朋友请求
     */
    @Override
    public ResponseData operatorFriendRequest(String acceptUserId, String sendUserId, Integer operType) {
        Example example = new Example(FriendRequest.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("sendUserId",sendUserId);
        criteria.andEqualTo("acceptUserId", acceptUserId);
        criteria.andEqualTo("status", 1);
        FriendRequest search_result=friendRequestMapper.selectOneByExample(example);
        search_result.setStatus(operType);//操作类型对应请求类型
        if(friendRequestMapper.updateByPrimaryKey(search_result)>0){

            if(operType==OperatorFriendRequestTypeEnum.IGNORE.getType()){
                return ResponseData.ok("忽略好友请求成功");
            }else if(OperatorFriendRequestTypeEnum.PASS.type==operType){
                //好友关系（好友关系是相互的，要添加两条记录）
                MyFriends acceptUserFriend=new MyFriends();
                acceptUserFriend.setMineId(acceptUserId);
                acceptUserFriend.setFriendId(sendUserId);
                if(myFriendsMapper.selectOne(acceptUserFriend)!=null){
                    List<MyFriendsVO> myFriendsVOS=myFriendsMapper.queryMyFriends(acceptUserId);
                    return ResponseData.ok("对方已是你的好友").putDataValue("myFriendList",myFriendsVOS);
                }
                acceptUserFriend.setFriendshipId(StringUtil.getRandomString());
                acceptUserFriend.setIsDel(DeleteStatusEnum.NOT_DELETE.getCode());
                MyFriends sendUserFriend=new MyFriends();
                sendUserFriend.setFriendshipId(StringUtil.getRandomString());
                sendUserFriend.setMineId(sendUserId);
                sendUserFriend.setFriendId(acceptUserId);
                sendUserFriend.setIsDel(DeleteStatusEnum.NOT_DELETE.getCode());

                if(myFriendsMapper.insert(acceptUserFriend)>0){
                    if(myFriendsMapper.insert(sendUserFriend)>0) {
                        List<MyFriendsVO> myFriendsVOS=myFriendsMapper.queryMyFriends(acceptUserId);
                        return ResponseData.ok("添加好友请求成功").putDataValue("myFriendList",myFriendsVOS);
                    }
                }
            }
            return ResponseData.ok("拒绝好友请求成功");
        }
        return ResponseData.error("操作好友请求失败");
    }
}
