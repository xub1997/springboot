package com.xub.wechat.controller;


import com.xub.wechat.pojo.bo.UserBO;
import com.xub.wechat.service.UploadService;
import com.xub.wechat.utils.ResponseData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @ClassName UploadController
 * @Description TODO
 * @Author lqx
 * @Date 2019/3/11.17:16
 **/
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;



    /**
     * @Description: 上传用户头像
     */
    @PostMapping("/uploadAvatarBase64")
    public ResponseData uploadAvatarBase64(@RequestBody UserBO userBO) throws Exception {
        return uploadService.uploadAvatarBase64(userBO);
    }
}
