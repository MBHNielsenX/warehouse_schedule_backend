package com.example.warehouse_schedule_backend.security.entity;

import com.example.warehouse_schedule_backend.security.dto.UserWithRolesRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.beans.Transient;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type")
@SuperBuilder
public class UserWithRoles implements UserDetails {

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, unique = true)
    String username;

    @Column(nullable = false, length = 100, unique = true)
    String email;

    //60 = length of a bcrypt encoded password
    @Column(nullable = false, length = 60)
    String password;

    private boolean enabled = true;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime edited;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('ADMIN', 'USER')")
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "security_role")
    List<Role> roles = new ArrayList<>();

    public UserWithRoles() {
    }

    //Used when users must be created via HTTP-request
    public UserWithRoles(UserWithRolesRequest body) {
        this.username = body.getUsername();
        this.email = body.getEmail();
        this.setPassword(body.getPassword());
    }

    public UserWithRoles(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = passwordEncoder.encode(password);
    }

    public UserWithRoles(Long id, String userName, String password, String email) {
        this.id = id;
        this.username = userName;
        setPassword(password);
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = passwordEncoder.encode(password);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.name())).collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return enabled;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
