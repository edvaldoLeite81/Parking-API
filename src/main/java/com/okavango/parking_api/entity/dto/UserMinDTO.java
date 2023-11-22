package com.okavango.parking_api.entity.dto;

import com.okavango.parking_api.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserMinDTO {

    private Long id;
    private String userName;
    private  String role;

    public UserMinDTO(User user){
        String userRole = String.valueOf(user.getRole());
        id = user.getId();
        userName = user.getUserName();
        role = userRole.substring("ROLE_".length());
    }
}
