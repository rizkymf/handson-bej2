package org.binar.chapter4.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JurusanRepositoryTest {

    @Autowired
    JurusanRepository jurusanRepository;

    @Test
    void testStoreProcedure() {
        jurusanRepository.changeFakultas1("03", "01");
    }
}
