package com.noelnp.sportsbooklite.modules.bet.domain.repository;

import com.noelnp.sportsbooklite.modules.bet.infra.jpa.BetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BetRepository extends JpaRepository<BetEntity, Long> {
}
