/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.zhuoli.tfeepay.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author shaohua.wsh
 * @version $Id: DateUtils.java, v 0.1 2019-06-19 6:07 PM shaohua.wsh Exp $$
 */
public class DateUtils {

    /**
     * 
     * @param date
     * @param format
     * @return
     */
    public static String format(Date date, String format) {

        DateFormat dateFormat = new SimpleDateFormat(format);

        return dateFormat.format(date);
    }
}