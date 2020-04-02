package com.edu.formSystem.model.domain;

/**
 * @author zr
 * @program: formSystem
 * @Title: formNumber
 * @package: com.edu.formSystem
 * @description: 表单实体类
 */
public class formNumber {
    /*表单数据id（唯一）*/
    private String formNumberId;
    /*表单id*/
    private String formId;
    /*表单数据内容*/
    private String formNumberContent;
    /*填表人id（游客标null）*/
    private String userId;

    public formNumber(String formNumberId, String formId, String formNumberContent, String userId) {
        this.formNumberId = formNumberId;
        this.formId = formId;
        this.formNumberContent = formNumberContent;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "formNumber{" +
                "formNumberId='" + formNumberId + '\'' +
                ", formId='" + formId + '\'' +
                ", formNumberContent='" + formNumberContent + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public String getFormNumberId() {
        return formNumberId;
    }

    public void setFormNumberId(String formNumberId) {
        this.formNumberId = formNumberId;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getFormNumberContent() {
        return formNumberContent;
    }

    public void setFormNumberContent(String formNumberContent) {
        this.formNumberContent = formNumberContent;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
