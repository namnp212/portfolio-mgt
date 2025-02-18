package com.namnp.portfolio_service.controller;

import com.namnp.portfolio_service.dto.PortfolioDTO;
import com.namnp.portfolio_service.model.Portfolio;
import com.namnp.portfolio_service.service.PorfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/portfolio")
public class PortfolioController {
    @Autowired
    PorfolioService porfolioService;

    @GetMapping("get-all")
    public ResponseEntity<List<PortfolioDTO>> getAllPortfolio(){
        return new ResponseEntity<>(porfolioService.findAll(), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<PortfolioDTO> createPortfolio(@RequestBody PortfolioDTO portfolioDTO){
        return new ResponseEntity(porfolioService.savePortfolio(portfolioDTO),HttpStatus.CREATED);
    }

    @PutMapping("edit")
    public  ResponseEntity<PortfolioDTO> editPortfolio (@RequestBody PortfolioDTO portfolioDTO){
        return new ResponseEntity(porfolioService.savePortfolio(portfolioDTO),HttpStatus.OK);
    }
}
