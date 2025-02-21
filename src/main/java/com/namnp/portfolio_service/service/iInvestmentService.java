package com.namnp.portfolio_service.service;

import com.namnp.portfolio_service.dto.InvestmentDTO;

import java.util.List;

public interface iInvestmentService {
    public List<InvestmentDTO> findAll();
    public InvestmentDTO save(InvestmentDTO dto);
    public InvestmentDTO findById(long id);
}
