package com.rspace.repositories;

import com.rspace.model.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UserRepository {

    Optional<User> findById(Long aLong);
}
