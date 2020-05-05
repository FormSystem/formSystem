package com.edu.formSystem.service.impl;

import com.edu.formSystem.model.domain.Form;
import com.edu.formSystem.model.domain.FormStructure;
import com.edu.formSystem.repository.FormManagementDao;
import com.edu.formSystem.service.FormManagementService;
import com.edu.formSystem.utils.GetUidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
public class FormManagementServiceImpl implements FormManagementService {
    @Autowired
    private FormManagementDao formManagementDao;

    @Override
    public Optional<Integer> createForm(String formName, String formUserId, int formNumber, int formWidth, String formAlignment) {
        String formId = GetUidUtils.getNewId();
        String formTime = GetUidUtils.getTime();
        return Optional.ofNullable(
                formManagementDao.createForm(formId,formName,formUserId,formTime,formNumber,formWidth,formAlignment));
    }

    @Override
    public Optional<Integer> changeForm(String formId, String formName, String formUserId, String formTime, int formNumber, int formWidth, String formAlignment) {
        return Optional.ofNullable(
                formManagementDao.changeForm(formId,formName,formUserId,formTime,formNumber,formWidth,formAlignment));
    }

    @Override
    public Optional<Integer> addFormNumber(String formId) {
        return Optional.ofNullable(
                formManagementDao.addFormNumber(formId));
    }

    @Override
    public Optional<Form> isFormNameUsed(String formName) {
        return Optional.ofNullable(
                formManagementDao.isFormNameUsed(formName));
    }

    @Override
    public Optional<Integer> deleteFromByFromId(String formId) {
        return Optional.ofNullable(
                formManagementDao.deleteFromByFromId(formId));
    }

    @Override
    public Optional<List<Form>> findAllForm() {
        return Optional.ofNullable(
                formManagementDao.findAllForm());
    }

    @Override
    public Optional<Form> findForm(String formId) {
        return Optional.ofNullable(
                formManagementDao.findForm(formId));
    }

    @Override
    public Optional<Integer> createFormStructure(String formId, int formFieldId, String formFieldName, String fieldAttributesValue, int formFieldOrder) {
        String formStructureId = GetUidUtils.getNewId();
        return Optional.ofNullable(
                formManagementDao.createFormStructure(
                        formStructureId,formId,formFieldId,formFieldName,fieldAttributesValue,formFieldOrder));
    }

    @Override
    public Optional<List<FormStructure>> findFormStructureByFormId(String formId) {
        List<FormStructure> formStructure = formManagementDao.findFormStructureByFormId(formId);
        formStructure.forEach(formStructure1 -> {
            formStructure1.setFormFieldAttributesName(formManagementDao.findFormFieldAttributesByFormFieldId(formStructure1.getFormFieldId()));
        });
        return Optional.of(formStructure);
    }

    @Override
    public Optional<Integer> changeFormStructure(String formStructureId, String formId, int formFieldId, String formFieldName, String fieldAttributesValue, int formFieldOrder) {
        return Optional.ofNullable(
                formManagementDao.changeFormStructure(
                        formStructureId,formId,formFieldId,formFieldName,fieldAttributesValue,formFieldOrder));
    }

    @Override
    public Optional<Integer> deleteFromStructureByFromStructureId(String formStructureId) {
        return Optional.ofNullable(
                formManagementDao.deleteFromStructureByFromStructureId(formStructureId));
    }

    @Override
    public Optional<List<String>> findFormFieldAttributesByFormFieldId(int formFieldId) {
        return Optional.ofNullable(
                formManagementDao.findFormFieldAttributesByFormFieldId(formFieldId));
    }
}
