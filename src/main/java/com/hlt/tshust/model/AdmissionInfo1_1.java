package com.hlt.tshust.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "admission_info_1_1")
public class AdmissionInfo1_1 {
    @Id
    private Integer accountId;

    private String subject;
    private String award;
    private String rankAward;
    private String proofImageUrl;
    private String preference1;
    private String preference2;
    private String preference3;
    private String status;

    @OneToOne
    @MapsId
    @JoinColumn(name = "account_id")
    private Accounts accounts;
}

