/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.zhuoli.tfeepay.service;

import com.zhuoli.tfeepay.entity.response.UserInfo;

/**
 *
 * @author shaohua.wsh
 * @version $Id: AlipayAuthService.java, v 0.1 2019-06-19 10:39 AM shaohua.wsh Exp $$
 */
public interface AlipayAuthService {
    /**
     * 根据authCode获取用户信息
     *
     * @param authCode 授权码
     *
     * @return
     */
    UserInfo getUserInfoByAuthCode(String authCode) throws Exception;

    /**
     * 
     * @param authCode
     * @return
     * @throws Exception
     */
    String getUserId(String authCode) throws Exception;
}