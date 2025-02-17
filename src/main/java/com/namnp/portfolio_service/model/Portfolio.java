package com.namnp.portfolio_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Portfolio {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    String name;

    @Enumerated(EnumType.STRING)
    PortfolioRiskLevel riskLevel;

    @OneToMany(mappedBy = "portfolio")
    List<Investment> investments;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PortfolioRiskLevel getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(PortfolioRiskLevel riskLevel) {
        this.riskLevel = riskLevel;
    }

    public List<Investment> getInvestments() {
        return investments;
    }

    public void setInvestments(List<Investment> investments) {
        this.investments = investments;
    }
}
