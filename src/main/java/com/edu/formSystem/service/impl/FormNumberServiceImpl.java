package com.edu.formSystem.service.impl;

import com.edu.formSystem.model.domain.FormNumber;
import com.edu.formSystem.repository.FormNumberDao;
import com.edu.formSystem.service.FormNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
public class FormNumberServiceImpl implements FormNumberService {
    @Autowired
    private FormNumberDao formNumberDao;

    @Override
    public Optional<Integer> insertFormNumber(String formNumberId, String formId, String formNumberContent, String userId) {
        return Optional.ofNullable(formNumberDao.insertFormNumber(formNumberId,formId,formNumberContent,userId));
    }

    @Override
    public Optional<Integer> changeFormNumber(String formNumberId, String formId, String formNumberContent, String userId) {
        return Optional.ofNullable(formNumberDao.changeFormNumber(formNumberId,formId,formNumberContent,userId));
    }

    @Override
    public Optional<FormNumber> findFormNumberByFormNumberId(String formNumberId) {
        return Optional.ofNullable(formNumberDao.findFormNumberByFormNumberId(formNumberId));
    }

    @Override
    public Optional<Integer> deleteFormNumberByFormNumberId(String formNumberId) {
        return Optional.ofNullable(formNumberDao.deleteFormNumberByFormNumberId(formNumberId));
    }

    @Override
    public Optional<List<FormNumber>> findAllFormNumber(String formId) {
        return Optional.ofNullable(formNumberDao.findAllFormNumber(formId));
    }
}
