package com.hlt.tshust.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "admission_scores")
public class AdmissionScores {
    @Id
    private Integer accountId;

    private Float academicScore;
    private Float achievementScore;
    private Float extraPointsMajorChoice;
    private Float extraPointsOther;
    private Float interviewScore;
    private Float totalScore;
    private String status;

    @OneToOne
    @MapsId
    @JoinColumn(name = "account_id")
    private Accounts accounts;
}

