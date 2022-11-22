package org.binar.chapter6;

import org.binar.chapter6.DemoGeneric;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

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


    public void useGeneric() {
        DemoGeneric<String> demoGeneric = new DemoGeneric<>();
        List<Integer> integerList = new ArrayList<>();
        demoGeneric.printList(integerList);

        List<String> stringList = new ArrayList<>();
        demoGeneric.printList(stringList);
    }
}
