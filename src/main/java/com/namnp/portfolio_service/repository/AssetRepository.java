package com.namnp.portfolio_service.repository;

import com.namnp.portfolio_service.model.Asset;
import com.namnp.portfolio_service.model.AssetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {
    public Optional<Asset> findByTypeAndSymbol(AssetType type, String symbol);

    public List<Asset> findByType(AssetType type);
}
