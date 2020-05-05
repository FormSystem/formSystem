package com.edu.formSystem.model.domain;

import java.io.Serializable;
import java.util.List;

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
    private String formFieldName;
    /*表单字段属性值*/
    private String fieldAttributesValue;
    /*表单字段顺序*/
    private String formFieldOrder;
    /*表单字段属性值*/
    private List<String> formFieldAttributesName;

    public FormStructure(){}

    public FormStructure(String formStructureId, String formId, int formFieldId, String formFieldName, String fieldAttributesValue, String formFieldOrder, List<String> formFieldAttributesName) {
        this.formStructureId = formStructureId;
        this.formId = formId;
        this.formFieldId = formFieldId;
        this.formFieldName = formFieldName;
        this.fieldAttributesValue = fieldAttributesValue;
        this.formFieldOrder = formFieldOrder;
        this.formFieldAttributesName = formFieldAttributesName;
    }

    @Override
    public String toString() {
        return "FormStructure{" +
                "formStructureId='" + formStructureId + '\'' +
                ", formId='" + formId + '\'' +
                ", formFieldId=" + formFieldId +
                ", formFieldName='" + formFieldName + '\'' +
                ", fieldAttributesValue='" + fieldAttributesValue + '\'' +
                ", formFieldOrder='" + formFieldOrder + '\'' +
                ", formFieldAttributesName=" + formFieldAttributesName +
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



    public List<String> getFormFieldAttributesName() {
        return formFieldAttributesName;
    }

    public void setFormFieldAttributesName(List<String> formFieldAttributesName) {
        this.formFieldAttributesName = formFieldAttributesName;
    }

    public String getFormFieldName() {
        return formFieldName;
    }

    public void setFormFieldName(String formFieldName) {
        this.formFieldName = formFieldName;
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
