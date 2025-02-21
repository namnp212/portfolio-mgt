package com.namnp.portfolio_service.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Portfolio {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private PortfolioRiskLevel riskLevel;
    @ManyToOne
    @JoinColumn(name = "fin_detail_id")
    UserFinancialDetail userFinancialDetail;
    @OneToMany(mappedBy = "portfolio", cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JsonManagedReference
    private List<Investment> investments;

    private double cash;

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

    public UserFinancialDetail getUserFinancialDetail() {
        return userFinancialDetail;
    }

    public void setUserFinancialDetail(UserFinancialDetail userFinancialDetail) {
        this.userFinancialDetail = userFinancialDetail;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }
}
