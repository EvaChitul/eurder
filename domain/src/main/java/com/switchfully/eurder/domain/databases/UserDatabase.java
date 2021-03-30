package com.switchfully.eurder.domain.databases;

import com.switchfully.eurder.domain.elements.Roles;
import com.switchfully.eurder.domain.elements.User;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class UserDatabase {

    private final Map<UUID, User> users = new HashMap<>();

    public Collection<User> getAllUsers(){
        return users.values();
    }

    public User createUser(User user){
        users.put(user.getId(), user);
        return users.get(user.getId());
    }

    public boolean isAdmin(UUID userId) {
        return users.get(userId).getRole() == Roles.ADMIN;
    }
}
