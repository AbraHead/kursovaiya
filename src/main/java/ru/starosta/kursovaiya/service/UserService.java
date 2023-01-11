package ru.starosta.kursovaiya.service;

import ru.starosta.kursovaiya.dto.UserDto;
import ru.starosta.kursovaiya.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();


}

