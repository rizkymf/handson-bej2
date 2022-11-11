package org.binar.chapter5.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DemoRestTemplateTest {

    @Autowired
    DemoRestTemplate demoRestTemplate;

    @Test
    void test1() {
        demoRestTemplate.testRestTemplate();
    }
}
