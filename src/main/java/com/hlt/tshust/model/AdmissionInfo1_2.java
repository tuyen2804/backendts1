package com.hlt.tshust.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "admission_info_1_2")
public class AdmissionInfo1_2 {
    @Id
    private Integer accountId;

    private String certificate;
    private String certificateId;
    private Float score;
    private String proofImageUrl;
    private String recommendationLetterUrl;
    private String preference1;
    private String preference2;
    private String preference3;
    private String status;

    @OneToOne
    @MapsId
    @JoinColumn(name = "account_id")
    private Accounts accounts;
}

