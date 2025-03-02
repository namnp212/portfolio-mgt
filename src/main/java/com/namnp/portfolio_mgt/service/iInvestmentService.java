package com.namnp.portfolio_mgt.service;

import com.namnp.portfolio_mgt.dto.InvestmentDTO;

import java.util.List;

public interface iInvestmentService {
    public List<InvestmentDTO> findAll();
    public InvestmentDTO save(InvestmentDTO dto);
    public InvestmentDTO findById(long id);
}
