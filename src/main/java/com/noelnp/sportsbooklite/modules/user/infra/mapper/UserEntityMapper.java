package com.noelnp.sportsbooklite.modules.user.infra.mapper;

import com.noelnp.sportsbooklite.modules.user.presentation.dto.UserResponse;
import com.noelnp.sportsbooklite.modules.user.infra.jpa.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    UserResponse toResponse(UserEntity user);
}
