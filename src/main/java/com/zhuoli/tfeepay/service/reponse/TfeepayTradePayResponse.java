/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.zhuoli.tfeepay.service.reponse;

/**
 *
 * @author shaohua.wsh
 * @version $Id: TfeepayTradePayResponse.java, v 0.1 2019-06-19 5:38 PM shaohua.wsh Exp $$
 */
public class TfeepayTradePayResponse {

    /** 是否成功 */
    private boolean success;

    /**
     * Getter method for property <tt>success</tt>.
     *
     * @return property value of success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Setter method for property <tt>success</tt>.
     *
     * @param success value to be assigned to property success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }
}