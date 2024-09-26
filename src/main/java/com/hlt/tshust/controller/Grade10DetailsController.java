package com.hlt.tshust.controller;

import com.hlt.tshust.model.Grade10Details;
import com.hlt.tshust.service.Grade10DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/grade10")
public class Grade10DetailsController {

    @Autowired
    private Grade10DetailsService grade10DetailsService;

    // Endpoint thêm mới hoặc cập nhật chi tiết điểm lớp 10
    @PostMapping("/saveOrUpdate")
    public String saveOrUpdateGrade10Details(@RequestBody Grade10Details grade10Details) {
        grade10DetailsService.saveOrUpdateGrade10Details(grade10Details);
        return "Grade 10 details have been saved/updated successfully.";
    }
}

