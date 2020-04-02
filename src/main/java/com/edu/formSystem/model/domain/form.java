package com.edu.formSystem.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author zr
 * @program: formSystem
 * @Title: form
 * @package: com.edu.formSystem
 * @description: 表单实体类
 */
public class form {
    /*表单ID*/
    private String formId;
    /*表单名*/
    private String formName;
    /*表单结构*/
    private String formStructure;
    /*表单创建者id（外键）*/
    private String formUserId;
    /*表单创建时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String formTime;
    /*表单数据量*/
    private int formNumber;

    public form(String formId, String formName, String formStructure, String formUserId, String formTime, int formNumber) {
        this.formId = formId;
        this.formName = formName;
        this.formStructure = formStructure;
        this.formUserId = formUserId;
        this.formTime = formTime;
        this.formNumber = formNumber;
    }

    @Override
    public String toString() {
        return "form{" +
                "formId='" + formId + '\'' +
                ", formName='" + formName + '\'' +
                ", formStructure='" + formStructure + '\'' +
                ", formUserId='" + formUserId + '\'' +
                ", formTime='" + formTime + '\'' +
                ", formNumber=" + formNumber +
                '}';
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getFormStructure() {
        return formStructure;
    }

    public void setFormStructure(String formStructure) {
        this.formStructure = formStructure;
    }

    public String getFormUserId() {
        return formUserId;
    }

    public void setFormUserId(String formUserId) {
        this.formUserId = formUserId;
    }

    public String getFormTime() {
        return formTime;
    }

    public void setFormTime(String formTime) {
        this.formTime = formTime;
    }

    public int getFormNumber() {
        return formNumber;
    }

    public void setFormNumber(int formNumber) {
        this.formNumber = formNumber;
    }
}
