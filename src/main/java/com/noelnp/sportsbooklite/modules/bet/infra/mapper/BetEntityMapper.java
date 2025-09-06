package com.noelnp.sportsbooklite.modules.bet.infra.mapper;

import com.noelnp.sportsbooklite.modules.bet.infra.jpa.BetEntity;
import com.noelnp.sportsbooklite.modules.bet.presentation.dto.BetResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BetEntityMapper {

    BetResponse toResponse(BetEntity bet);
}
