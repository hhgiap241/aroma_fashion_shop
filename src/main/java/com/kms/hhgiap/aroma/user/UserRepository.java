package com.kms.hhgiap.aroma.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    // generate code automatically at runtime
    // @Query("SELECT u FROM User u WHERE u.email = ?1")
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail_1(String email);

    Optional<User> findByEmail(String email);
}
