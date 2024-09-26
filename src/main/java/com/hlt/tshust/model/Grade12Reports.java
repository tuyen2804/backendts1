package com.hlt.tshust.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "grade_12_reports")
public class Grade12Reports {
    @Id
    private Integer accountId;

    private String district;
    private String school;

    @OneToOne
    @MapsId
    @JoinColumn(name = "account_id")
    private Accounts accounts;
}


