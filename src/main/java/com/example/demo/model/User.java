package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Users")
@Getter
@Setter
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    private String surname;
    @NotBlank
    @Email
    @Size(max = 50)
    private String email;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String repeatedPassword;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Roles> roles;

        private boolean isAccountNonExpired = true;
        private boolean isAccountNonLocked = true;
        private boolean isCredentialsNonExpired = true;
        private boolean isEnabled = true;


        public User() {}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }
}
