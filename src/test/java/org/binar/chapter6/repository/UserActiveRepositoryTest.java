package org.binar.chapter6.repository;

import org.binar.chapter6.model.UserActive;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserActiveRepositoryTest {

    @Autowired
    UserActiveRepository userActiveRepository;

    @Test
    void testAddData() {
        // siapin object userActive yang berisi data userActive
        UserActive userActive = new UserActive();
        userActive.setNama("Rizky Mochamad Fauzi");
        userActive.setNomorHape("0808080808");
        userActive.setEmail("email@email.com");
        userActive.setState(true);

        // insert data userActive ke table ybs
        userActiveRepository.save(userActive);
    }
}
