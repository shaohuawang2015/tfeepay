/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.zhuoli.tfeepay.service;

import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.zhuoli.tfeepay.service.reponse.TfeepayTradeCreateResponse;
import com.zhuoli.tfeepay.service.reponse.TfeepayTradePayResponse;
import com.zhuoli.tfeepay.service.requet.TfeepayTradeCreateRequest;

/**
 *
 * @author shaohua.wsh
 * @version $Id: AlipayTradeService.java, v 0.1 2019-06-19 5:21 PM shaohua.wsh Exp $$
 */
public interface AlipayTradeService {

    /**
     * 交易创建
     *
     * @param request
     * @return
     */
    public TfeepayTradeCreateResponse create(TfeepayTradeCreateRequest request) throws Exception;

    /**
     * 交易支付
     *
     * @param response
     * @return
     */
    public TfeepayTradePayResponse pay(AlipayTradeAppPayResponse response) throws Exception;

}