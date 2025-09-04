package com.noelnp.sportsbooklite.dto.bet;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CreateBetRequest(
        @NotNull Long userId,

        @NotNull Long eventId,

        @NotNull @Positive BigDecimal odds,

        @NotNull @Positive BigDecimal amount
) {}