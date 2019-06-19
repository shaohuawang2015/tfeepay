/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.zhuoli.tfeepay.config.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.zhuoli.tfeepay.config.Constants;

/**
 *
 * @author shaohua.wsh
 * @version $Id: DefaultAlipayClientFactory.java, v 0.1 2019-06-19 11:05 AM shaohua.wsh Exp $$
 */
@Component
public class DefaultAlipayClientFactory implements FactoryBean<AlipayClient>, InitializingBean {

    /** 日志信息 */
    private static final Logger logger       = LoggerFactory
                                                 .getLogger(DefaultAlipayClientFactory.class);
    private AlipayClient        alipayClient = null;

    /** 环境配置 */
    @Autowired
    protected Environment       config;

    @Override
    public AlipayClient getObject() throws Exception {
        return alipayClient;
    }

    @Override
    public Class<?> getObjectType() {
        return AlipayClient.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        String URL = config.getProperty("alipay.gateway");
        // 商户APP_ID
        String APP_ID = config.getProperty("alipay.appId");
        // 商户RSA 私钥
        String APP_PRIVATE_KEY = config.getProperty("app.privatekey");
        // 支付宝公钥
        String ALIPAY_PUBLIC_KEY = config.getProperty("alipay.publickey");

        alipayClient = new DefaultAlipayClient(URL, APP_ID, APP_PRIVATE_KEY,
            Constants.ALIPAY_FORMAT, Constants.ALIPAY_CHARSET, ALIPAY_PUBLIC_KEY,
            Constants.ALIPAY_SIGN_TYP);

        logger.info("Init AlipayClient Success", APP_ID, URL);

    }
}