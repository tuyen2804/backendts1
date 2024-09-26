package com.hlt.tshust.model;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

@Data
@Entity
@Table(name = "students")
public class Students {

    @Id
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

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date issueDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
}


