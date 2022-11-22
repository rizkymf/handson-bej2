package org.binar.chapter6.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table( name = "users",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = "username"),
            @UniqueConstraint(columnNames = "email")
        })
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(min = 6, max = 16)
    private String password;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable( name = "userxrole",
        joinColumns = @JoinColumn(name ="user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public Users(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public Users(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Users() {

    }


}
