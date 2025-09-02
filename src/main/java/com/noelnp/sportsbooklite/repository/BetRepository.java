package com.noelnp.sportsbooklite.repository;

import com.noelnp.sportsbooklite.entity.Bet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BetRepository extends JpaRepository<Bet, Long> {
}
