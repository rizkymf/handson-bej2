package org.binar.chapter5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanExample {

    @Bean
    public String method1() {
        System.out.println("ini adalah method 1");
        return "method1";
    }

    @Bean
    public Integer method2() {
        System.out.println("yang ini mah method 2");
        return 0;
    }

    public String method3() {
        System.out.println("sedangkan yg ini method 3");
        return "non bean";
    }
}
