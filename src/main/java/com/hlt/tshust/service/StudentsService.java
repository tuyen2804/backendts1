package com.hlt.tshust.service;

import com.hlt.tshust.dto.students.StudentsRequest;
import com.hlt.tshust.model.Students;
import com.hlt.tshust.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class StudentsService {

    @Autowired
    private StudentsRepository studentsRepository;

    // Thêm hoặc cập nhật thông tin sinh viên dựa trên StudentsRequest
    public Students saveOrUpdateStudent(StudentsRequest studentRequest) {
        Optional<Students> existingStudent = studentsRepository.findById(studentRequest.getAccountId());

        Students student;
        if (existingStudent.isPresent()) {
            // Nếu đã tồn tại, cập nhật thông tin
            student = existingStudent.get();
        } else {
            // Nếu chưa tồn tại, thêm mới
            student = new Students();
            student.setAccountId(studentRequest.getAccountId());
        }

        // Cập nhật thông tin từ StudentsRequest vào entity Students
        student.setPhotoUrl(studentRequest.getPhotoUrl());
        student.setIdCardFrontUrl(studentRequest.getIdCardFrontUrl());
        student.setIdCardBackUrl(studentRequest.getIdCardBackUrl());
        student.setFullName(studentRequest.getFullName());
        student.setBirthCity(studentRequest.getBirthCity());
        student.setBirthDistrict(studentRequest.getBirthDistrict());
        student.setBirthWard(studentRequest.getBirthWard());
        student.setIdNumber(studentRequest.getIdNumber());
        student.setNationality(studentRequest.getNationality());
        student.setGender(studentRequest.getGender());
        student.setIssuePlace(studentRequest.getIssuePlace());
        student.setEthnicity(studentRequest.getEthnicity());
        student.setReligion(studentRequest.getReligion());
        student.setIssueDate(convertStringToDate(studentRequest.getIssueDate()));
        student.setBirthDate(convertStringToDate(studentRequest.getBirthDate()));

        return studentsRepository.save(student);
    }

    // Hàm chuyển đổi chuỗi thành Date
    private Date convertStringToDate(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formatter.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException("Invalid date format");
        }
    }
}

