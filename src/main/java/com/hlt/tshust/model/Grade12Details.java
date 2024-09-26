package com.hlt.tshust.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "grade_12_details")
public class Grade12Details {
    @Id
    private Integer accountId;

    private Float mathSem1;
    private Float mathSem2;
    private Float physicsSem1;
    private Float physicsSem2;
    private Float chemistrySem1;
    private Float chemistrySem2;
    private Float literatureSem1;
    private Float literatureSem2;
    private Float englishSem1;
    private Float englishSem2;
    private Float biologySem1;
    private Float biologySem2;
    private Float historySem1;
    private Float historySem2;
    private Float geographySem1;
    private Float geographySem2;
    private String proofImageUrl;

    @OneToOne
    @MapsId
    @JoinColumn(name = "account_id")
    private Accounts accounts;
}


