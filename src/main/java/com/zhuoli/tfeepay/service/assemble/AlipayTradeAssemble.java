/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.zhuoli.tfeepay.service.assemble;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alipay.api.request.AlipayTradeCreateRequest;
import com.alipay.api.response.AlipayTradeCreateResponse;
import com.zhuoli.tfeepay.service.reponse.TfeepayTradeCreateResponse;
import com.zhuoli.tfeepay.service.requet.TfeepayTradeCreateRequest;
import com.zhuoli.tfeepay.utils.GenOrderId;

/**
 *
 * @author shaohua.wsh
 * @version $Id: AlipayTradeAssemble.java, v 0.1 2019-06-19 5:54 PM shaohua.wsh Exp $$
 */
public class AlipayTradeAssemble {

    public static AlipayTradeCreateRequest assemble(TfeepayTradeCreateRequest request) {
        AlipayTradeCreateRequest alipayTradeCreateRequest = new AlipayTradeCreateRequest();
        Map<String, String> bizContent = new HashMap<>();
        bizContent.put("out_trade_no", GenOrderId.genTradeNo(new Date()));
        bizContent.put("total_amount", "0.01");
        bizContent.put("subject", "学费缴纳");
        bizContent.put("buyer_id", request.getUserId());
        alipayTradeCreateRequest.setBizContent(JSON.toJSONString(bizContent));

        return alipayTradeCreateRequest;
    }

    public static TfeepayTradeCreateResponse assemble(AlipayTradeCreateResponse response) {

        TfeepayTradeCreateResponse tfeepayTradeCreateResponse = new TfeepayTradeCreateResponse();

        tfeepayTradeCreateResponse.setTradeNo(response.getTradeNo());

        return tfeepayTradeCreateResponse;

    }
}