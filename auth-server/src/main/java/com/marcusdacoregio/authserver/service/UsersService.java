package com.marcusdacoregio.authserver.service;

import com.marcusdacoregio.authserver.dto.NewUserDto;

public interface UsersService {

    void createUser(NewUserDto newUser);
}
