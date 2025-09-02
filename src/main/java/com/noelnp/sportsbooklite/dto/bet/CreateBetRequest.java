package com.noelnp.sportsbooklite.dto.bet;

import java.math.BigDecimal;

public record CreateBetRequest(Long userId, long eventId, BigDecimal odds, BigDecimal amount) {
}
