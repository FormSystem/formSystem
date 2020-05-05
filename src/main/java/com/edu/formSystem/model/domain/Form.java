package com.edu.formSystem.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.List;

/**
 * @author zr
 * @program: formSystem
 * @Title: form
 * @package: com.edu.formSystem
 * @description: 表单实体类
 */
public class Form implements Serializable {

    private static final long serialVersionUID = -7015230098794004782L;
    /*表单ID*/
    private String formId;
    /*表单名*/
    private String formName;
    /*表单创建者id（外键）*/
    private String formUserId;
    /*表单创建时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String formTime;
    /*表单数据量*/
    private int formNumber;
    /*表单宽度（默认值100）*/
    private int formWidth;
    /*表单字段对齐方式*/
    private String formAlignment;
    /*表单结构链表*/
    private List<FormStructure> formStructureList;

    public Form(){}

    public Form(String formId, String formName, String formUserId, String formTime, int formNumber, int formWidth, String formAlignment, List<FormStructure> formStructureList) {
        this.formId = formId;
        this.formName = formName;
        this.formUserId = formUserId;
        this.formTime = formTime;
        this.formNumber = formNumber;
        this.formWidth = formWidth;
        this.formAlignment = formAlignment;
        this.formStructureList = formStructureList;
    }

    @Override
    public String toString() {
        return "Form{" +
                "formId='" + formId + '\'' +
                ", formName='" + formName + '\'' +
                ", formUserId='" + formUserId + '\'' +
                ", formTime='" + formTime + '\'' +
                ", formNumber=" + formNumber +
                ", formWidth=" + formWidth +
                ", formAlignment='" + formAlignment + '\'' +
                ", formStructureList=" + formStructureList +
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

    public int getFormWidth() {
        return formWidth;
    }

    public void setFormWidth(int formWidth) {
        this.formWidth = formWidth;
    }

    public String getFormAlignment() {
        return formAlignment;
    }

    public void setFormAlignment(String formAlignment) {
        this.formAlignment = formAlignment;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<FormStructure> getFormStructureList() {
        return formStructureList;
    }

    public void setFormStructureList(List<FormStructure> formStructureList) {
        this.formStructureList = formStructureList;
    }
}
