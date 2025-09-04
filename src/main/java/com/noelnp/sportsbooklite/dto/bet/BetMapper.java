package com.noelnp.sportsbooklite.dto.bet;

import com.noelnp.sportsbooklite.dto.user.UserResponse;
import com.noelnp.sportsbooklite.entity.Bet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BetMapper {

    BetResponse toResponse(Bet bet);
}
