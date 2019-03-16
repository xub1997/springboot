package com.xub.wechat.controller;


import com.xub.wechat.pojo.ChatMsg;
import com.xub.wechat.service.ChatMsgService;
import com.xub.wechat.utils.ResponseData;
import com.xub.wechat.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatMsgController {

    @Autowired
    private ChatMsgService chatMsgService;

    /**
     *
     * @Description: 用户手机端获取未签收的消息列表
     */
    @GetMapping("/getUnReadMsgList")
    public ResponseData getUnReadMsgList(@RequestParam("acceptUserId") String acceptUserId) {
        // 0. userId 判断不能为空
        if (StringUtil.isEmpty(acceptUserId)) {
            return ResponseData.error("用户id不能为空");
        }
        // 查询列表
        List<ChatMsg> unreadMsgList = chatMsgService.getUnReadMsgList(acceptUserId);
        return ResponseData.ok("获取成功").putDataValue("unreadMsgList",unreadMsgList);
    }
}
