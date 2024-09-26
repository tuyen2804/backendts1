package com.hlt.tshust.repository;

import com.hlt.tshust.model.Grade10Details;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Grade10DetailsRepository extends JpaRepository<Grade10Details, Integer> {
    // Repository để thao tác với bảng grade_10_details
}

