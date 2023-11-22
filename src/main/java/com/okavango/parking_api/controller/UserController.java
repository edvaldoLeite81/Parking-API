package com.okavango.parking_api.controller;

import com.okavango.parking_api.entity.dto.UserMinDTO;
import com.okavango.parking_api.entity.dto.UserRegistrationDTO;
import com.okavango.parking_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserMinDTO registration(@RequestBody UserRegistrationDTO userRegistrationDTO){
        return userService.registration(userRegistrationDTO);
    }

    @GetMapping
    public List<UserMinDTO> all(){
        return userService.all();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserMinDTO> byId(@PathVariable Long id){
        return userService.findBy(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return userService.delete(id);
    }
}
