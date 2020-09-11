package com.marcusdacoregio.authserver.controller;

import com.marcusdacoregio.authserver.domain.entity.User;
import com.marcusdacoregio.authserver.dto.NewUserDto;
import com.marcusdacoregio.authserver.dto.UserDto;
import com.marcusdacoregio.authserver.mapper.UserMapper;
import com.marcusdacoregio.authserver.service.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UsersController {

    private final UsersService usersService;
    private final UserMapper userMapper;

    public UsersController(UsersService usersService,
                           UserMapper userMapper) {
        this.usersService = usersService;
        this.userMapper = userMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody NewUserDto newUser) {
        usersService.createUser(newUser);
    }

    @GetMapping("/me")
    public UserDto getUser(Principal principal) {
        User user = (User) ((OAuth2Authentication) principal).getUserAuthentication().getPrincipal();
        return userMapper.toUserDto(user);
    }

}
