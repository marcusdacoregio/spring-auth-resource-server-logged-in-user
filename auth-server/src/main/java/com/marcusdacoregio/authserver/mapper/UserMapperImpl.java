package com.marcusdacoregio.authserver.mapper;

import com.marcusdacoregio.authserver.domain.entity.User;
import com.marcusdacoregio.authserver.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toUserDto(User user) {
        UserDto dto = new UserDto();
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        return dto;
    }

}
