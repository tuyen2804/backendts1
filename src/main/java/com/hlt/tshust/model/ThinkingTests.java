package com.hlt.tshust.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "thinking_tests")
public class ThinkingTests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer testId;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "accountId")
    private Accounts accounts;

    private String testRound;
    private String testLocation;

    @Temporal(TemporalType.DATE)
    private Date registrationStart;

    @Temporal(TemporalType.DATE)
    private Date registrationEnd;

    private Integer maxRegistrations;

    @Temporal(TemporalType.DATE)
    private Date testDate;
}



