package com.kms.hhgiap.aroma;

import com.kms.hhgiap.aroma.user.User;
import com.kms.hhgiap.aroma.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
    @Autowired private UserRepository userRepository;

    @Test
    public void testFindByEmail() {
        String email = "johnny.jimenez@example.com";
        User user = userRepository.findByEmail_1(email);
        assertThat(user).isNotNull();
    }
}
