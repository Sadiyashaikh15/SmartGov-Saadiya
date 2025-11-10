package com.example.SmartGov.service;

import com.example.SmartGov.dto.UserDto;
import com.example.SmartGov.entity.User;
import com.example.SmartGov.enums.ROLES;
import com.example.SmartGov.exception.ResouceNotFoundException;
import com.example.SmartGov.mapper.UserMapper;
import com.example.SmartGov.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //create
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.toUserEntity(userDto);
        if (user.getRole() == ROLES.OFFICERS) {
            System.out.println("Officer account created successfully!");
        } else if (user.getRole() == ROLES.CITIZENS) {
            System.out.println("Citizen account created successfully!");
        } else if (user.getRole() == ROLES.ADMIN) {
            System.out.println("Admin account created successfully!");

        }
        user = userRepository.save(user);
        return UserMapper.toUserDto(user);
    }

    // get all user
    public List<UserDto> getAllUser() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toUserDto)
                .toList();
    }

    //get by id
    public UserDto getUserById(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResouceNotFoundException("User not found with this id "));
        return UserMapper.toUserDto(user);
    }

    //update
    public UserDto updateUser(Long id , UserDto userDto){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setAadharNumber(userDto.getAadharNumber());
        user.setEmail(userDto.getEmail());
        user.setMobileNumber(userDto.getMobileNumber());
        user.setStates(userDto.getState());
        user.setDistrict(userDto.getDistrict());
        user.setGender(userDto.getGender());
        user.setCreatedAt(userDto.getCreatedAt());
        userRepository.save(user);
        return UserMapper.toUserDto(user);
    }
}
