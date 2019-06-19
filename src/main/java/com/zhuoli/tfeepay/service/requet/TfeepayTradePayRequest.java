/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.zhuoli.tfeepay.service.requet;

/**
 *
 * @author shaohua.wsh
 * @version $Id: TfeepayTradePayRequest.java, v 0.1 2019-06-19 5:37 PM shaohua.wsh Exp $$
 */
public class TfeepayTradePayRequest {

    private String tradeNo;

    /**
     * Getter method for property <tt>tradeNo</tt>.
     *
     * @return property value of tradeNo
     */
    public String getTradeNo() {
        return tradeNo;
    }

    /**
     * Setter method for property <tt>tradeNo</tt>.
     *
     * @param tradeNo value to be assigned to property tradeNo
     */
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }
}