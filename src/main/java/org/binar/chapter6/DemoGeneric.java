package org.binar.chapter6;

import java.util.ArrayList;
import java.util.List;

public class DemoGeneric<T> {

    T genericType;

    public DemoGeneric(T generic) {
        this.genericType = generic;
    }

    public DemoGeneric() {
    }

    public T getObject() {
        return this.genericType;
    }

    public void printList(List<?> datas) {
        datas.forEach(val -> {
            System.out.println(val);
        });
    }

    public List<?> printApaYa() {
        return new ArrayList<>();
    }
}
