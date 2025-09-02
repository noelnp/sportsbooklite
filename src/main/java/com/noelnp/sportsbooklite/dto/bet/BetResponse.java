package com.noelnp.sportsbooklite.dto.bet;

import java.math.BigDecimal;

public record BetResponse(Long id, Long eventId, BigDecimal amount, BigDecimal odd, BigDecimal potentialWin) {
}
