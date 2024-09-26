package com.hlt.tshust.controller;

import com.hlt.tshust.model.Grade10Reports;
import com.hlt.tshust.service.Grade10ReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/grade10Reports")
public class Grade10ReportsController {

    @Autowired
    private Grade10ReportsService grade10ReportsService;

    // Endpoint thêm mới hoặc cập nhật báo cáo điểm lớp 10
    @PostMapping("/saveOrUpdate")
    public String saveOrUpdateGrade10Reports(@RequestBody Grade10Reports grade10Reports) {
        grade10ReportsService.saveOrUpdateGrade10Reports(grade10Reports);
        return "Grade 10 report has been saved/updated successfully.";
    }
}
