package com.kms.hhgiap.aroma.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void createUser(User user) throws UserException {
        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
        if(optionalUser.isPresent()) {
            throw new UserException("User already exists");
        }
        if(!user.getPassword().equals(user.getConfirmPassword())) {
            throw new UserException("Passwords do not match");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }
//    public boolean login(String email, String password) throws UserException {
//        Optional<User> optionalUser = userRepository.findByEmail(email);
//        if (!optionalUser.isPresent()) {
//            throw new UserException("User does not exist");
//        }
//        if(!optionalUser.get().isEnabled()) {
//            throw new UserException("User is not active");
//        }
//        if(!optionalUser.get().getPassword().equals(password)) {
//            throw new UserException("Password is incorrect");
//        }
//        return true;
//    }
}
