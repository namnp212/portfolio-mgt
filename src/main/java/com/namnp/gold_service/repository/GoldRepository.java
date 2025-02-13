package com.namnp.gold_service.repository;

import com.namnp.gold_service.model.GoldPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoldRepository extends JpaRepository<GoldPrice, Integer> {
}
