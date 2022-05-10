package com.kms.hhgiap.aroma.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired private UserRepository userRepository;

    public void createUser(User user) throws UserException {
        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
        if(optionalUser.isPresent()) {
            throw new UserException("User already exists");
        }
        if(!user.getPassword().equals(user.getConfirmPassword())) {
            throw new UserException("Passwords do not match");
        }
        userRepository.save(user);
    }
}
