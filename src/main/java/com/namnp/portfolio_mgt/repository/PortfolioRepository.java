package com.namnp.portfolio_mgt.repository;

import com.namnp.portfolio_mgt.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
}
