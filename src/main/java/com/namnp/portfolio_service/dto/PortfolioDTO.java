package com.namnp.portfolio_service.dto;

import com.namnp.portfolio_service.model.Investment;
import com.namnp.portfolio_service.model.PortfolioRiskLevel;


import java.util.List;

public class PortfolioDTO {
    private long id;
    private String name;
    private String riskLevel;
    private List<InvestmentDTO> investments;

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

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public List<InvestmentDTO> getInvestments() {
        return investments;
    }

    public void setInvestments(List<InvestmentDTO> investments) {
        this.investments = investments;
    }
}
