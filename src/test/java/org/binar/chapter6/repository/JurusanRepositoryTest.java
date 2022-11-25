package org.binar.chapter6.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
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
            log.info(obj.writeValueAsString(jurusanRepository.findAll().get(0)));
//            System.out.println(obj.writeValueAsString(jurusanRepository.findAll().get(0)));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
//        jurusanRepository.findAll().forEach(jrs -> {
//
//        });
    }
}
