package com.hlt.tshust.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "language_certificates")
public class LanguageCertificates {
    @Id
    private Integer accountId;

    private String certificate;
    private String certificateId;

    @Temporal(TemporalType.DATE)
    private java.util.Date issueDate;

    private Float score;
    private Float convertedScore;
    private String proofImageUrl;
    private String status;

    @OneToOne
    @MapsId
    @JoinColumn(name = "account_id")
    private Accounts accounts;
}

