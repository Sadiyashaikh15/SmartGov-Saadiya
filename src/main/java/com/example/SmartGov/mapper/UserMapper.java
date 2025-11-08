package com.example.SmartGov.mapper;

import com.example.SmartGov.dto.UserDto;
import com.example.SmartGov.entity.User;

public class UserMapper {

    // entity to dto

    public static UserDto toUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setDateOfBirth(user.getDateOfBirth());
        userDto.setAadharNumber(user.getAadharNumber());
        userDto.setEmail(user.getEmail());
        userDto.setMobileNumber(user.getMobileNumber());
        userDto.setState(user.getStates());
        userDto.setDistrict(user.getDistrict());
        userDto.setGender(user.getGender());
        userDto.setRole(user.getRole());
        userDto.setCreatedAt(user.getCreatedAt());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(userDto.getPassword());

        return userDto;
    }

  //  Dto to entity

    public static User toUserEntity(UserDto userDto){
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setAadharNumber(userDto.getAadharNumber());
        user.setEmail(userDto.getEmail());
        user.setMobileNumber(userDto.getMobileNumber());
        user.setStates(userDto.getState());
        user.setDistrict(userDto.getDistrict());
        user.setGender(userDto.getGender());
        user.setRole(userDto.getRole());
        user.setCreatedAt(userDto.getCreatedAt());
        user.setPassword(userDto.getPassword());
        user.setUsername(userDto.getUsername());

        return user;
    }
}
