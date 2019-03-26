package com.kyoshisakuda.auth.user;

import java.util.Optional;

public interface UserService {

    Optional<User> getUser(String username);

}
