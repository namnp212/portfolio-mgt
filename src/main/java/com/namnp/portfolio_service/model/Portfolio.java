package com.namnp.portfolio_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Set;

//@Entity
public class Portfolio {
//    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    String name;
    PortfolioRiskLevel riskLevel;

    Set<Investment> investments;

}
