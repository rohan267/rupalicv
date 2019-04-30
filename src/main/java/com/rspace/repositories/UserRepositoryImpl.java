package com.rspace.repositories;

import com.rspace.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public abstract class UserRepositoryImpl implements UserRepository {

    @Override
    public Optional<User> findById(Long aLong) {
        User user = new User();
        user.setFirstName("Rohan");
        user.setLastName("Parekh");
        user.setEmail("rohan.parekh.in@gmail.com");
        user.setPhone("+49-176-5902-6005");
        user.setLinkedUrl("https://www.linkedin.com/in/rohan-parekh/");
        user.setId(1L);

        return Optional.of(user);
    }
}
