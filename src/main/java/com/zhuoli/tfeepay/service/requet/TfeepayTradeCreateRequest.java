/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.zhuoli.tfeepay.service.requet;

/**
 *
 * @author shaohua.wsh
 * @version $Id: TfeepayTradeCreateRequest.java, v 0.1 2019-06-19 5:25 PM shaohua.wsh Exp $$
 */
public class TfeepayTradeCreateRequest {

    /** 用户ID */
    private String userId;

    /** 学校 */
    private String school;

    /** 年级 */
    private String grade;

    /** 姓名 */
    private String name;

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
     * Getter method for property <tt>school</tt>.
     *
     * @return property value of school
     */
    public String getSchool() {
        return school;
    }

    /**
     * Setter method for property <tt>school</tt>.
     *
     * @param school value to be assigned to property school
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * Getter method for property <tt>grade</tt>.
     *
     * @return property value of grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * Setter method for property <tt>grade</tt>.
     *
     * @param grade value to be assigned to property grade
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     *
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }
}