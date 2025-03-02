package com.namnp.portfolio_mgt.repository;

import com.namnp.portfolio_mgt.model.UserFinancialDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFinancialDetailRepository extends JpaRepository<UserFinancialDetail, Long> {
}
