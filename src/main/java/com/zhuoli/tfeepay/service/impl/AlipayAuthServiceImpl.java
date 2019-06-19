/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.zhuoli.tfeepay.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import com.zhuoli.tfeepay.entity.response.UserInfo;
import com.zhuoli.tfeepay.service.AlipayAuthService;
import com.zhuoli.tfeepay.utils.CheckUtils;

/**
 *
 * @author shaohua.wsh
 * @version $Id: AlipayAuthServiceImpl.java, v 0.1 2019-06-19 10:43 AM shaohua.wsh Exp $$
 */
@Component
public class AlipayAuthServiceImpl implements AlipayAuthService {

    private static final Logger logger = org.slf4j.LoggerFactory
                                           .getLogger(AlipayAuthServiceImpl.class);
    @Autowired
    private AlipayClient        alipayClient;

    @Override
    public UserInfo getUserInfoByAuthCode(String authCode) throws Exception {
        if (CheckUtils.isBlank(authCode)) {
            throw new Exception("授权编码不能为空");
        }

        AlipaySystemOauthTokenResponse alipaySystemOauthTokenResponse = this
            .getAccessToken(authCode);
        if (!alipaySystemOauthTokenResponse.isSuccess()) {
            logger.warn("换取 AuthToken 失败！错误编码：{}, 错误信息：{}",
                alipaySystemOauthTokenResponse.getCode(), alipaySystemOauthTokenResponse.getMsg());

            throw new Exception("换取 AuthToken 失败 code=" + alipaySystemOauthTokenResponse.getCode()
                                + ", msg=" + alipaySystemOauthTokenResponse.getMsg());
        }
        String accessToken = alipaySystemOauthTokenResponse.getAccessToken();

        logger.info("通过AuthCode:{} 换取AuthToken:{} 成功！", authCode, accessToken);

        // get user by accessToken
        AlipayUserInfoShareResponse alipayUserInfoShareResponse = this
            .getUserInfoFromAlipay(accessToken);
        String userId = alipayUserInfoShareResponse.getUserId();
        if (CheckUtils.isBlank(userId)) {
            logger.warn("获取用户信息失败 错误编码：{}, 错误信息：{}", alipaySystemOauthTokenResponse.getCode(),
                alipaySystemOauthTokenResponse.getMsg());

            throw new Exception("获取用户信息失败 code=" + alipayUserInfoShareResponse.getCode() + ", msg="
                                + alipayUserInfoShareResponse.getBody());
        }

        UserInfo userInfo = this
            .convertFromAlipayUserInfoShareResponse(alipayUserInfoShareResponse);

        logger.info("获取用户信息成功！ 当前用户名：{}， 用户图标：{}", userInfo.getNickName(), userInfo.getAvatar());

        userInfo.setAccessToken(accessToken);
        userInfo.setRefreshToken(alipaySystemOauthTokenResponse.getRefreshToken());

        return userInfo;
    }

    @Override
    public String getUserId(String authCode) throws Exception {

        if (CheckUtils.isBlank(authCode)) {
            throw new Exception("授权编码不能为空");
        }

        AlipaySystemOauthTokenResponse alipaySystemOauthTokenResponse = this
            .getAccessToken(authCode);
        if (!alipaySystemOauthTokenResponse.isSuccess()) {
            logger.warn("换取 AuthToken 失败！错误编码：{}, 错误信息：{}",
                alipaySystemOauthTokenResponse.getCode(), alipaySystemOauthTokenResponse.getMsg());

            throw new Exception("换取 AuthToken 失败 code=" + alipaySystemOauthTokenResponse.getCode()
                                + ", msg=" + alipaySystemOauthTokenResponse.getMsg());
        }
        return alipaySystemOauthTokenResponse.getUserId();
    }

    private AlipaySystemOauthTokenResponse getAccessToken(String authCode)
                                                                          throws AlipayApiException {
        AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
        request.setGrantType("authorization_code");
        request.setCode(authCode);
        //request.setRefreshToken("201208134b203fe6c11548bcabd8da5bb087a83b");
        return alipayClient.execute(request);
    }

    private AlipayUserInfoShareResponse getUserInfoFromAlipay(String accessToken)
                                                                                 throws AlipayApiException {
        AlipayUserInfoShareRequest request = new AlipayUserInfoShareRequest();
        return alipayClient.execute(request, accessToken);
    }

    private UserInfo convertFromAlipayUserInfoShareResponse(AlipayUserInfoShareResponse alipayUserInfoShareResponse) {
        UserInfo userInfo = new UserInfo();
        String nickName = alipayUserInfoShareResponse.getNickName();
        userInfo.setUserId(alipayUserInfoShareResponse.getUserId());
        userInfo.setNickName(CheckUtils.isBlank(nickName) ? "" : nickName);
        String avatar = alipayUserInfoShareResponse.getAvatar();
        userInfo.setAvatar(CheckUtils.isBlank(avatar) ? "" : avatar);
        // now
        userInfo.setModifyTime(new Date());
        return userInfo;
    }
}