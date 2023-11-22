package com.okavango.parking_api.service;

import com.okavango.parking_api.entity.User;
import com.okavango.parking_api.entity.dto.UserMinDTO;
import com.okavango.parking_api.entity.dto.UserRegistrationDTO;
import com.okavango.parking_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserMinDTO registration(UserRegistrationDTO userRegistrationDTO){
        User user = new User(userRegistrationDTO.getUserName(), userRegistrationDTO.getPassword());
        user = userRepository.save(user);
        UserMinDTO newUser = new UserMinDTO(user);
        return newUser;
    }
}
