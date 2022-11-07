package org.binar.chapter4.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Test
    void testJoinColumn() {
        ObjectMapper obj = new ObjectMapper();
        try {
            System.out.println(obj.writeValueAsString(jurusanRepository.findAll().get(0)));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
//        jurusanRepository.findAll().forEach(jrs -> {
//
//        });
    }
}
