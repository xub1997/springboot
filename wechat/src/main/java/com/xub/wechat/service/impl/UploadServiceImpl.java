package com.xub.wechat.service.impl;

import com.xub.wechat.pojo.User;
import com.xub.wechat.pojo.bo.UserBO;
import com.xub.wechat.service.UploadService;
import com.xub.wechat.service.UserService;
import com.xub.wechat.utils.FastDFSClient;
import com.xub.wechat.utils.FileUtils;
import com.xub.wechat.utils.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName UploadServiceImpl
 * @Description TODO
 * @Author lqx
 * @Date 2019/3/11.21:24
 **/
@Service("uploadService")
public class UploadServiceImpl implements UploadService {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Value("${temp.basePath}")
    private String basePath;

    @Value("${temp.avatarFileName}")
    private String avatarFileName;

    @Autowired
    private UserService userService;

    @Autowired
    private FastDFSClient fastDFSClient;


    @Override
    public ResponseData uploadAvatarBase64(UserBO userBO) throws Exception {
        // 获取前端传过来的base64字符串, 然后转换为文件对象再上传
        String base64Data = userBO.getAvatarData();
        //临时文件
        String userFacePath = basePath + userBO.getUserid() + avatarFileName;
        FileUtils.base64ToFile(userFacePath, base64Data);

        // 上传文件到fastdfs
        MultipartFile faceFile = FileUtils.fileToMultipart(userFacePath);
        String url = fastDFSClient.uploadBase64(faceFile);
        logger.info("上传头像地址为：{}",url);

        // 获取缩略图的url
        String thump = "_80x80.";
        String arr[] = url.split("\\.");
        String thumpImgUrl = arr[0] + thump + arr[1];

        // 更新用户头像
        User user = new User();
        user.setUserid(userBO.getUserid());
        user.setAvatarUrl(thumpImgUrl);
        user.setAvatarUrlBig(url);
        User result=userService.updateUserInfo(user);
        return ResponseData.ok("上传头像成功").putDataValue("user",result);
    }
}
