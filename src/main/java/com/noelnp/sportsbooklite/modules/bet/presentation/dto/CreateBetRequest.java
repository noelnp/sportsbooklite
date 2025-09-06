package com.noelnp.sportsbooklite.modules.bet.presentation.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CreateBetRequest(
        @NotNull Long userId,

        @NotNull Long eventId,

        @NotNull @Positive BigDecimal odds,

        @NotNull @Positive BigDecimal amount
) {}