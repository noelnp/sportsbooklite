package com.noelnp.sportsbooklite.service;

import com.noelnp.sportsbooklite.dto.bet.BetResponse;
import com.noelnp.sportsbooklite.dto.bet.CreateBetRequest;
import com.noelnp.sportsbooklite.entity.Bet;
import com.noelnp.sportsbooklite.repository.BetRepository;
import org.springframework.stereotype.Service;

@Service
public class BetService {

    private final BetRepository betRepository;


    public BetService(BetRepository betRepository) {
        this.betRepository = betRepository;
    }

    public BetResponse createNewBet(CreateBetRequest createBetRequest) {
        Bet bet = new Bet();
        bet.setUserId(createBetRequest.userId());
        bet.setEventId(createBetRequest.eventId());
        bet.setOdds(createBetRequest.odds());
        bet.setAmount(createBetRequest.amount());

        Bet saved = betRepository.save(bet);

        return new BetResponse(
                saved.getId(),
                saved.getEventId(),
                saved.getAmount(),
                saved.getOdds(),
                saved.getPotentialWin()
        );


    }
}
