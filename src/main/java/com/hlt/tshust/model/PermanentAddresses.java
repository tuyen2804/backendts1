package com.hlt.tshust.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "permanent_addresses")
public class PermanentAddresses {
    @Id
    private Integer accountId;

    private String city;
    private String district;
    private String ward;
    private String streetAddress;

    @OneToOne
    @MapsId
    @JoinColumn(name = "account_id")
    private Accounts accounts;
}

