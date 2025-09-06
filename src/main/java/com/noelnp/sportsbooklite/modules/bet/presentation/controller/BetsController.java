package com.noelnp.sportsbooklite.modules.bet.presentation.controller;

import com.noelnp.sportsbooklite.modules.bet.presentation.dto.BetResponse;
import com.noelnp.sportsbooklite.modules.bet.presentation.dto.CreateBetRequest;
import com.noelnp.sportsbooklite.modules.bet.app.BetService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bets")
public class BetsController {

    private final BetService betService;

    public BetsController(BetService betService) {
        this.betService = betService;
    }

    @PostMapping("/create")
    public ResponseEntity<BetResponse> createNewBet(@Valid @RequestBody CreateBetRequest createBetRequest) {
        BetResponse response = betService.createNewBet(createBetRequest);
        return ResponseEntity.ok(response);

    }

}
