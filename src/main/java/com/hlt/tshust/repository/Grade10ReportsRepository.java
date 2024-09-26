package com.hlt.tshust.repository;

import com.hlt.tshust.model.Grade10Reports;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Grade10ReportsRepository extends JpaRepository<Grade10Reports, Integer> {
    // Repository để thao tác với bảng grade_10_reports
}
