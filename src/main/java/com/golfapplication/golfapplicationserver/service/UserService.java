package com.golfapplication.golfapplicationserver.service;

import com.golfapplication.golfapplicationserver.models.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
