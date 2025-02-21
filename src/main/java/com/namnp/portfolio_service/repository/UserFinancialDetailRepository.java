package com.namnp.portfolio_service.repository;

import com.namnp.portfolio_service.model.UserFinancialDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFinancialDetailRepository extends JpaRepository<UserFinancialDetail, Long> {
}
