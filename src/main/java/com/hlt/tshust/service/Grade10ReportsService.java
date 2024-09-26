package com.hlt.tshust.service;

import com.hlt.tshust.model.Grade10Reports;
import com.hlt.tshust.repository.Grade10ReportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Grade10ReportsService {

    @Autowired
    private Grade10ReportsRepository grade10ReportsRepository;

    // Thêm mới hoặc cập nhật báo cáo điểm lớp 10
    public Grade10Reports saveOrUpdateGrade10Reports(Grade10Reports grade10Reports) {
        Optional<Grade10Reports> existingReport = grade10ReportsRepository.findById(grade10Reports.getAccountId());

        if (existingReport.isPresent()) {
            // Nếu báo cáo đã tồn tại, cập nhật thông tin
            Grade10Reports updateReport = existingReport.get();
            updateReport.setDistrict(grade10Reports.getDistrict());
            updateReport.setSchool(grade10Reports.getSchool());
            return grade10ReportsRepository.save(updateReport);
        } else {
            // Nếu chưa có, thêm mới
            return grade10ReportsRepository.save(grade10Reports);
        }
    }
}

