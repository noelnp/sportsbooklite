package com.noelnp.sportsbooklite.dto.user;

import com.noelnp.sportsbooklite.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse toResponse(User user);
}
