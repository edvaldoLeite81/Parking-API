package com.okavango.parking_api.entity;

import com.okavango.parking_api.entity.enumerated.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

import static com.okavango.parking_api.entity.enumerated.Role.ROLE_CLIENT;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String userName;

    @Column(nullable = false, length = 200)
    private String password;

    private LocalDateTime creationDate;

    private LocalDateTime modificationDate;

    private String createdBy;

    private String modifiedBy;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 25)
    private Role role = ROLE_CLIENT;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
