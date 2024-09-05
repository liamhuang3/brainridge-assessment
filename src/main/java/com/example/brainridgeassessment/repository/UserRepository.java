package com.example.brainridgeassessment.repository;

import com.example.brainridgeassessment.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepository {
    private final Map<Long, User> users = new HashMap<>();
    private final AtomicLong counter = new AtomicLong(1);

    public Long getNextId() {
        return counter.getAndIncrement();  // Increment counter atomically
    }

    public void save(User user) {
        users.put(user.getId(), user);
    }

    public Optional<User> getFromId(Long id) {
        return Optional.ofNullable(users.get(id));
    }
}
