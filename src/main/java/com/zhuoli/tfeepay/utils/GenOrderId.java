/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.zhuoli.tfeepay.utils;

import java.util.Date;
import java.util.Random;

/**
 *
 * @author shaohua.wsh
 * @version $Id: GenOrderId.java, v 0.1 2019-06-19 6:03 PM shaohua.wsh Exp $$
 */
public class GenOrderId {

    private static final String DATE_NUM_FORMAT = "yyyyMMddHHmmss";

    public static String genTradeNo(Date date) {

        StringBuilder tradeBuilder = new StringBuilder();

        tradeBuilder.append(DateUtils.format(date, DATE_NUM_FORMAT));

        Random random = new Random();

        int serialNo = random.nextInt(100);

        tradeBuilder.append(String.format("%03d", serialNo));

        return tradeBuilder.toString();

    }
}