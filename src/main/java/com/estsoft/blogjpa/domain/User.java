package com.estsoft.blogjpa.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;


@Table(name = "users")
@NoArgsConstructor
@Getter
@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @CreatedDate
    private LocalDateTime createdAt;

    @Builder
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getUsername() {
        System.out.println(id + ", email: " + email);
        return email;
    }

    @Override
    public String getPassword() {
        System.out.println(id + ", pw: " + password);
        return password;
    }
    // 계정 만류 여부 반환 (true:만료 안됨)
    @Override
    public boolean isAccountNonExpired() {
        System.out.println("isAccountNonExpired()");
        return true;
    }

    //계정 잠금 여부 반환 (true:잠금 안됨)
    @Override
    public boolean isAccountNonLocked() {
        System.out.println("isAccountNonLocked()");
        return true;
    }

    // 패스워드의 만료 여부 반환 (true: 만료 안됨)
    @Override
    public boolean isCredentialsNonExpired() {
        System.out.println("isCredentialsNonExpired()");
        return true;
    }

    // 계정 사용 여부 반환 (true: 사용 가능)
    @Override
    public boolean isEnabled() {
        System.out.println("isEnabled()");
        return true;
    }

}

