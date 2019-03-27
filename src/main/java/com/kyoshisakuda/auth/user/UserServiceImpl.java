package com.kyoshisakuda.auth.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {

    private final Set<GrantedAuthority> ROLE_USER;
    private final Set<GrantedAuthority> ROLE_ADMIN;
    private final Set<User> USERS;

    @Autowired
    public UserServiceImpl(PasswordEncoder encoder) {
        ROLE_USER = Stream.of(
                new SimpleGrantedAuthority("ROLE_USER")
        ).collect(Collectors.toSet());

        ROLE_ADMIN = Stream.of(
                new SimpleGrantedAuthority("ROLE_ADMIN")
        ).collect(Collectors.toSet());

        USERS = Stream.of(
                new User("ksakuda", encoder.encode("perrito"), ROLE_USER),
                new User("admin", encoder.encode("root"), ROLE_ADMIN)
        ).collect(Collectors.toSet());
    }

    @Override
    public Optional<User> getUser(String username) {
        return USERS.stream().filter(user -> user.getUsername().equalsIgnoreCase(username)).findFirst();
    }

}
