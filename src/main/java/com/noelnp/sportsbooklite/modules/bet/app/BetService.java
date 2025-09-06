package com.noelnp.sportsbooklite.modules.bet.app;

import com.noelnp.sportsbooklite.modules.bet.infra.jpa.BetEntity;
import com.noelnp.sportsbooklite.modules.bet.infra.mapper.BetEntityMapper;
import com.noelnp.sportsbooklite.modules.bet.presentation.dto.BetResponse;
import com.noelnp.sportsbooklite.modules.bet.presentation.dto.CreateBetRequest;
import com.noelnp.sportsbooklite.modules.bet.domain.repository.BetRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class BetService {

    private final BetRepository betRepository;
    private final BetEntityMapper betMapper;

    @PersistenceContext
    private EntityManager entityManager;


    public BetService(BetRepository betRepository, BetEntityMapper betMapper) {
        this.betRepository = betRepository;
        this.betMapper = betMapper;
    }

    @Transactional
    public BetResponse createNewBet(CreateBetRequest createBetRequest) {


        BetEntity bet = new BetEntity();
        bet.setUserId(createBetRequest.userId());
        bet.setEventId(createBetRequest.eventId());
        bet.setOdds(createBetRequest.odds());
        bet.setAmount(createBetRequest.amount());

        BetEntity saved = betRepository.save(bet);
        entityManager.refresh(saved);

        return betMapper.toResponse(saved);

    }
}
