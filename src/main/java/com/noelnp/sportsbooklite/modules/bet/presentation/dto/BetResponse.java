package com.noelnp.sportsbooklite.modules.bet.presentation.dto;

import java.math.BigDecimal;

public record BetResponse(Long id, Long eventId, BigDecimal amount, BigDecimal odds, BigDecimal potentialWin) {
}
