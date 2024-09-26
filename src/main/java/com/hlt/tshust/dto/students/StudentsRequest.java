package com.hlt.tshust.dto.students;

import lombok.Data;

@Data
public class StudentsRequest {
    private Integer accountId;
    private String photoUrl;
    private String idCardFrontUrl;
    private String idCardBackUrl;
    private String fullName;
    private String birthCity;
    private String birthDistrict;
    private String birthWard;
    private String idNumber;
    private String nationality;
    private String gender;
    private String issuePlace;
    private String ethnicity;
    private String religion;
    private String issueDate;
    private String birthDate;

    // Getters và Setters
}

