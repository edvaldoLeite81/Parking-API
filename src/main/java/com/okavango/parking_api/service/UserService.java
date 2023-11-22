package com.okavango.parking_api.service;

import com.okavango.parking_api.entity.User;
import com.okavango.parking_api.entity.dto.UserMinDTO;
import com.okavango.parking_api.entity.dto.UserRegistrationDTO;
import com.okavango.parking_api.exceptions.ResourceNotFoundException;
import com.okavango.parking_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // registration
    @Transactional
    public UserMinDTO registration(UserRegistrationDTO userRegistrationDTO) {
        User user = new User(userRegistrationDTO.getUserName(), userRegistrationDTO.getPassword());
        user = userRepository.save(user);
        UserMinDTO newUser = new UserMinDTO(user);
        return newUser;
    }

    // return all
    @Transactional(readOnly = true)
    public List<UserMinDTO> all() {
        return userRepository.findAll().stream().map(UserMinDTO::new).toList();
    }


    // find by id
    @Transactional(readOnly = true)
    public ResponseEntity<UserMinDTO> findBy(Long id) {

        String message = "Resource With Id " + id + " Not Found";

        Optional<User> u = userRepository.findById(id);

        if (u.isPresent()) {
            User user = u.get();
            UserMinDTO userMinDTO = new UserMinDTO(user);
            return ResponseEntity.ok(userMinDTO);
        } else {
            throw new ResourceNotFoundException(id, message);
        }
    }

    @Transactional
    public ResponseEntity<Void> delete(Long id) {
        String message = "Resource With Id " + id + " Not Found";

        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException(id, message);
        }

        try {
            userRepository.deleteById(id);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException(id, e.getMessage());
        }

        return ResponseEntity.noContent().build();
    }



}
