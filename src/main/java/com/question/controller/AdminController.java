package com.question.controller;

import com.question.model.QuestionEntity;
import com.question.service.FileUploaderService;
import com.question.service.QuestionService;
import com.question.util.ExcelGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private FileUploaderService fileUploaderService;


    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public String download(ModelMap model) {

        return "download-data";
    }

    @GetMapping("/export-to-excel")
    public void exportIntoExcelFile(HttpServletResponse response, ModelMap model) throws IOException {
        response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=QA_data.xlsx";
        response.setHeader(headerKey, headerValue);

        List<QuestionEntity> listOfStudents = questionService.fetchAllQuestionData();
        ExcelGenerator generator = new ExcelGenerator(listOfStudents);
        generator.generateExcelFile(response);
    }

    @GetMapping("/upload")
    public String upload(ModelMap model) {

        return "upload-data";
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, ModelMap model) {

        fileUploaderService.uploadFile(file);

        redirectAttributes.addFlashAttribute("message",
                "You have successfully uploaded '" + file.getOriginalFilename() + "' !");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "redirect:/upload";
    }

    @GetMapping("/saveData")
    public String saveExcelData(Model model) {

        List<QuestionEntity> excelDataAsList = fileUploaderService.getExcelDataAsList(0);
        int noOfRecords = fileUploaderService.saveExcelData(excelDataAsList);
        model.addAttribute("noOfRecords", noOfRecords);
        return "upload-success";
    }
}
