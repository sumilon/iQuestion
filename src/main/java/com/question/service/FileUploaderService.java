package com.question.service;

import com.question.model.QuestionEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileUploaderService {

    List<QuestionEntity> getExcelDataAsList(int index);

    int saveExcelData(List<QuestionEntity> invoices);

    public void uploadFile(MultipartFile file);
}
