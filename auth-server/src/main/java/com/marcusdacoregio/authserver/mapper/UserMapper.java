package com.marcusdacoregio.authserver.mapper;

import com.marcusdacoregio.authserver.domain.entity.User;
import com.marcusdacoregio.authserver.dto.UserDto;

public interface UserMapper {
    UserDto toUserDto(User user);
}
