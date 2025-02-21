package com.namnp.portfolio_service.impl;

import com.namnp.portfolio_service.dto.InvestmentDTO;
import com.namnp.portfolio_service.mapper.InvestmentMapper;
import com.namnp.portfolio_service.model.Asset;
import com.namnp.portfolio_service.model.Investment;
import com.namnp.portfolio_service.model.Portfolio;
import com.namnp.portfolio_service.repository.AssetRepository;
import com.namnp.portfolio_service.repository.InvestmentRepository;
import com.namnp.portfolio_service.repository.PortfolioRepository;
import com.namnp.portfolio_service.service.iInvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestmentServiceImp implements iInvestmentService {
    @Autowired
    InvestmentRepository investmentRepository;
    @Autowired
    AssetRepository assetRepository;
    @Autowired
    PortfolioRepository portfolioRepository;
    @Autowired
    InvestmentMapper investmentMapper;

    @Override
    public List<InvestmentDTO> findAll() { return investmentMapper.toDTO(investmentRepository.findAll());    }

    @Override
    public InvestmentDTO save(InvestmentDTO dto) {
        Investment toBeSave = investmentMapper.toModel(dto, investmentRepository.findById(dto.getId()).orElse(new Investment()));
        Asset asset = assetRepository.findById(dto.getAsset().getId()).orElse(new Asset());
        Portfolio portfolio = portfolioRepository.findById(dto.getPortfolio().getId()).orElse(new Portfolio());
        toBeSave.setAsset(asset);
        toBeSave.setPortfolio(portfolio);

        Investment saved = investmentRepository.save(toBeSave);
        return investmentMapper.toDTO(saved);
    }

    @Override
    public InvestmentDTO findById(long id) {
        return investmentMapper.toDTO(investmentRepository.findById(id).orElse(new Investment()));
    }
}
