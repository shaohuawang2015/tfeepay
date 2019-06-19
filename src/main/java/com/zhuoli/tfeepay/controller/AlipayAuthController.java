package com.zhuoli.tfeepay.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zhuoli.tfeepay.entity.response.UserInfo;
import com.zhuoli.tfeepay.service.AlipayAuthService;
import com.zhuoli.tfeepay.service.AlipayTradeService;
import com.zhuoli.tfeepay.service.reponse.TfeepayTradeCreateResponse;
import com.zhuoli.tfeepay.service.requet.TfeepayTradeCreateRequest;

/**
 * Created by NullPointer on 2018/10/29.
 */
@RestController
public class AlipayAuthController {

    /** 日志服务 */
    private static final Logger logger = LoggerFactory.getLogger(AlipayAuthController.class);

    @Autowired
    private AlipayAuthService   alipayAuthService;

    @Autowired
    private AlipayTradeService  alipayTradeService;

    @RequestMapping(value = "/alipay/auth", method = RequestMethod.GET)
    public UserInfo alipayAuth(String authCode) {

        logger.info("AlipayAuth", authCode);
        UserInfo userInfo = null;
        try {
            userInfo = alipayAuthService.getUserInfoByAuthCode(authCode);
        } catch (Exception e) {
            logger.error("AlipayAuthFail", e);
        }

        return userInfo;
    }

    @RequestMapping(value = "/alipay/userId", method = RequestMethod.GET)
    public String getAlipayUserId(String authCode) {

        logger.info("AlipayAuth", authCode);
        String userId = null;
        try {
            userId = alipayAuthService.getUserId(authCode);
        } catch (Exception e) {
            logger.error("AlipayAuthFail", e);
        }

        return userId;
    }

    @RequestMapping(value = "/alipay/trade/create", method = { RequestMethod.GET,
            RequestMethod.POST })
    public TfeepayTradeCreateResponse createTrade(String userId, String school, String grade,
                                                  String name) {

        logger.info("AlipayTradeCreate", userId, school, grade, name);
        TfeepayTradeCreateRequest request = new TfeepayTradeCreateRequest();
        request.setSchool(school);
        request.setUserId(userId);
        request.setName(name);
        request.setGrade(grade);

        TfeepayTradeCreateResponse response = null;
        try {
            response = alipayTradeService.create(request);
        } catch (Exception e) {
            logger.error("AlipayTradeCreate", e);
        }

        return response;
    }
}
