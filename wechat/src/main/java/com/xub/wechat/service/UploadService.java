package com.xub.wechat.service;

import com.xub.wechat.pojo.bo.UserBO;
import com.xub.wechat.utils.ResponseData;



public interface UploadService {
    public ResponseData uploadAvatarBase64(UserBO userBO) throws Exception;
}
