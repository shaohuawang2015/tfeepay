/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.zhuoli.tfeepay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradeCreateRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradeCreateResponse;
import com.zhuoli.tfeepay.service.AlipayTradeService;
import com.zhuoli.tfeepay.service.assemble.AlipayTradeAssemble;
import com.zhuoli.tfeepay.service.reponse.TfeepayTradeCreateResponse;
import com.zhuoli.tfeepay.service.reponse.TfeepayTradePayResponse;
import com.zhuoli.tfeepay.service.requet.TfeepayTradeCreateRequest;

/**
 *
 * @author shaohua.wsh
 * @version $Id: AlipayTradeServiceImpl.java, v 0.1 2019-06-19 5:47 PM shaohua.wsh Exp $$
 */
@Component
public class AlipayTradeServiceImpl implements AlipayTradeService {

    @Autowired
    private AlipayClient alipayClient;

    @Override
    public TfeepayTradeCreateResponse create(TfeepayTradeCreateRequest request) throws Exception {

        AlipayTradeCreateRequest alipayTradeCreateRequest = AlipayTradeAssemble.assemble(request);

        AlipayTradeCreateResponse response = (AlipayTradeCreateResponse) alipayClient
            .execute(alipayTradeCreateRequest);

        return AlipayTradeAssemble.assemble(response);
    }

    @Override
    public TfeepayTradePayResponse pay(AlipayTradeAppPayResponse response) throws Exception {
        return null;
    }
}