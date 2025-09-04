package com.noelnp.sportsbooklite.service;

import com.noelnp.sportsbooklite.dto.bet.BetMapper;
import com.noelnp.sportsbooklite.dto.bet.BetResponse;
import com.noelnp.sportsbooklite.dto.bet.CreateBetRequest;
import com.noelnp.sportsbooklite.entity.Bet;
import com.noelnp.sportsbooklite.repository.BetRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class BetService {

    private final BetRepository betRepository;
    private final BetMapper betMapper;

    @PersistenceContext
    private EntityManager entityManager;


    public BetService(BetRepository betRepository, BetMapper betMapper) {
        this.betRepository = betRepository;
        this.betMapper = betMapper;
    }

    @Transactional
    public BetResponse createNewBet(CreateBetRequest createBetRequest) {


        Bet bet = new Bet();
        bet.setUserId(createBetRequest.userId());
        bet.setEventId(createBetRequest.eventId());
        bet.setOdds(createBetRequest.odds());
        bet.setAmount(createBetRequest.amount());

        Bet saved = betRepository.save(bet);
        entityManager.refresh(saved);

        return betMapper.toResponse(saved);

    }
}
