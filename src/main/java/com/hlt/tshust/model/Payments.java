package com.hlt.tshust.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "payments")
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "accountId")
    private Accounts accounts;

    private String paymentDescription;

    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    private Float amount;
}


