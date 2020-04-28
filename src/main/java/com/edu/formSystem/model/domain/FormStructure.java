package com.edu.formSystem.model.domain;

import java.io.Serializable;

/**
 * @author zr
 * @program: formSystem
 * @Title: formStructure
 * @package: com.edu.formSystem
 * @description: 表单结构实体类
 */
public class FormStructure implements Serializable {

    private static final long serialVersionUID = 298257065422760845L;
    /*表单结构id（唯一）*/
    private String formStructureId;
    /*表单id（唯一）*/
    private String formId;
    /*表单字段id（唯一）*/
    private int formFieldId;
    /*表单字段名*/
    private String form_field_name;
    /*表单字段属性值*/
    private String fieldAttributesValue;
    /*表单字段顺序*/
    private String formFieldOrder;

    public FormStructure(){}

    public FormStructure(String formStructureId, String formId, int formFieldId, String form_field_name, String fieldAttributesValue, String formFieldOrder) {
        this.formStructureId = formStructureId;
        this.formId = formId;
        this.formFieldId = formFieldId;
        this.form_field_name = form_field_name;
        this.fieldAttributesValue = fieldAttributesValue;
        this.formFieldOrder = formFieldOrder;
    }

    @Override
    public String toString() {
        return "formStructure{" +
                "formStructureId='" + formStructureId + '\'' +
                ", formId='" + formId + '\'' +
                ", formFieldId=" + formFieldId +
                ", form_field_name='" + form_field_name + '\'' +
                ", fieldAttributesValue='" + fieldAttributesValue + '\'' +
                ", formFieldOrder='" + formFieldOrder + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFormStructureId() {
        return formStructureId;
    }

    public void setFormStructureId(String formStructureId) {
        this.formStructureId = formStructureId;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public int getFormFieldId() {
        return formFieldId;
    }

    public void setFormFieldId(int formFieldId) {
        this.formFieldId = formFieldId;
    }

    public String getForm_field_name() {
        return form_field_name;
    }

    public void setForm_field_name(String form_field_name) {
        this.form_field_name = form_field_name;
    }

    public String getFieldAttributesValue() {
        return fieldAttributesValue;
    }

    public void setFieldAttributesValue(String fieldAttributesValue) {
        this.fieldAttributesValue = fieldAttributesValue;
    }

    public String getFormFieldOrder() {
        return formFieldOrder;
    }

    public void setFormFieldOrder(String formFieldOrder) {
        this.formFieldOrder = formFieldOrder;
    }
}
