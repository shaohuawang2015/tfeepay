/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.zhuoli.tfeepay.utils;

/**
 *
 * @author shaohua.wsh
 * @version $Id: CheckUtils.java, v 0.1 2019-06-19 10:52 AM shaohua.wsh Exp $$
 */
public class CheckUtils {

    /**
     *
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        int length;
        if (str != null && (length = str.length()) != 0) {
            for (int i = 0; i < length; ++i) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }
}