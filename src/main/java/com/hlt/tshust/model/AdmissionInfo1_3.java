package com.hlt.tshust.model;

import jakarta.persistence.*;
import lombok.Data;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "admission_info_1_3")
public class AdmissionInfo1_3 {
    @Id
    private Integer accountId;

    private String selfIntroduction;
    private String teacherGender;
    private String teacherName;
    private String teacherPhone;
    private String teacherEmail;
    private Integer teacherOrder;
    private String teacherSchool;
    private String subjectTaught;
    private String teacherCity;
    private String teacherDistrict;
    private String teacherWard;
    private Float score;
    private String teacherRecommendationLetterUrl;
    private String specializedSchool;
    private String specializedClass;
    private String proofImageUrl;
    private String recommendationLetterUrl;
    private String admissionCombination;
    private String preference1;
    private String preference2;
    private String preference3;
    private String status;

    @OneToOne
    @MapsId
    @JoinColumn(name = "account_id")
    private Accounts accounts;
}


