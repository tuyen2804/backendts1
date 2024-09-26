package com.hlt.tshust.repository;

import com.hlt.tshust.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Students, Integer> {
    // Repository để thao tác với bảng students
}
