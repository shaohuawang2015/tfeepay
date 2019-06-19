/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.zhuoli.tfeepay.entity.response;

import java.util.Date;

/**
 *
 * @author shaohua.wsh
 * @version $Id: UserInfo.java, v 0.1 2019-06-19 10:37 AM shaohua.wsh Exp $$
 */
public class UserInfo {

    private Integer id;

    private String  userId;

    private String  nickName;

    private String  avatar;

    private String  accessToken;

    private String  refreshToken;

    private Date    modifyTime;

    /**
     * Getter method for property <tt>id</tt>.
     *
     * @return property value of id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     *
     * @param id value to be assigned to property id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter method for property <tt>userId</tt>.
     *
     * @return property value of userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Setter method for property <tt>userId</tt>.
     *
     * @param userId value to be assigned to property userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Getter method for property <tt>nickName</tt>.
     *
     * @return property value of nickName
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * Setter method for property <tt>nickName</tt>.
     *
     * @param nickName value to be assigned to property nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * Getter method for property <tt>avatar</tt>.
     *
     * @return property value of avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * Setter method for property <tt>avatar</tt>.
     *
     * @param avatar value to be assigned to property avatar
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * Getter method for property <tt>accessToken</tt>.
     *
     * @return property value of accessToken
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * Setter method for property <tt>accessToken</tt>.
     *
     * @param accessToken value to be assigned to property accessToken
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * Getter method for property <tt>refreshToken</tt>.
     *
     * @return property value of refreshToken
     */
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * Setter method for property <tt>refreshToken</tt>.
     *
     * @param refreshToken value to be assigned to property refreshToken
     */
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    /**
     * Getter method for property <tt>modifyTime</tt>.
     *
     * @return property value of modifyTime
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * Setter method for property <tt>modifyTime</tt>.
     *
     * @param modifyTime value to be assigned to property modifyTime
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}