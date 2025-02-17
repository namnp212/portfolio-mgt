package com.namnp.portfolio_service.controller;

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
    public ResponseEntity<List<Portfolio>> getAllPortfolio(){
        return new ResponseEntity<>(porfolioService.findAll(), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<Portfolio> createPortfolio(@RequestBody Portfolio portfolio){
        return new ResponseEntity(porfolioService.savePortfolio(portfolio),HttpStatus.CREATED);
    }
}
