package com.edu.formSystem.service.impl;

import com.edu.formSystem.model.domain.FormNumber;
import com.edu.formSystem.model.domain.FormStructure;
import com.edu.formSystem.repository.FormNumberDao;
import com.edu.formSystem.service.FormManagementService;
import com.edu.formSystem.service.FormNumberService;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
public class FormNumberServiceImpl implements FormNumberService {
    @Autowired
    private FormManagementService formManagementService;

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

    @Override
    public boolean outputFormNumberList(String formId)  throws IOException{
        //获取数据内容
       Optional<List<FormNumber>> formNumberListOptional = Optional.ofNullable(formNumberDao.findAllFormNumber(formId));
        //获取数据列表
        List<FormNumber> formNumberList = formNumberListOptional.get();
        //获取创建行数的数量（加title）
        int rowNumber = formNumberList.size()+1;
        //创建Excel工作薄
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("数据");
        XSSFRow row = sheet.createRow(0);
        //获取字段名
        List<FormStructure>  formStructures =formManagementService.findFormStructureByFormId(formId).get();
        //在第一行填写标题
        String title[] = new String[formStructures.size()];
        for (int i=0;i<formStructures.size();i++){
            title[i] = formStructures.get(i).getFormFieldName();
        }
        XSSFCell xssfCell;
        //将标题写入第一行单元格
        for (int i=0;i<title.length;i++){
            xssfCell = row.createCell(i);
            xssfCell.setCellValue(title[i]);
        }
        //填写数据
        for (int i=1;i<rowNumber;i++){
            row = sheet.createRow(i);
            String content[] = formNumberList.get(i-1).getFormNumberContent().split("\\*");
            for (int j=0;j<content.length;j++){
                xssfCell = row.createCell(j);
                xssfCell.setCellValue(content[j]);
            }
        }
        FileOutputStream outputStream = new FileOutputStream(new File("C:\\Users\\hp\\Desktop\\Number.xlsx"));
        workbook.write(outputStream);
        outputStream.close();
        return true;
    }
}
