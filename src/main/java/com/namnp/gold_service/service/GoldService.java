package com.namnp.gold_service.service;

import com.namnp.gold_service.model.GoldPrice;
import com.namnp.gold_service.repository.GoldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoldService {

    @Autowired
    GoldRepository goldRepository;

    public List<GoldPrice> getAll(){
        return goldRepository.findAll();
    }
}
