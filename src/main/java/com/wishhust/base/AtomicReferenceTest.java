package com.wishhust.base;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {
    public static void main(String[] args) {

        AtomicReference<Simple> atomicReference = new AtomicReference<>(new Simple("lk",1));

        boolean result = atomicReference.compareAndSet(new Simple("lk", 1), new Simple("lk3", 1));
        System.out.println(result);


        Simple lk = new Simple("lk", 1);
        AtomicReference<Simple> atomicReference2 = new AtomicReference<>(lk);
        boolean result2 = atomicReference2.compareAndSet(lk, new Simple("lk3", 1));
        System.out.println(result2);
    }

    static class Simple{
        private String name;
        private int age;

        public Simple(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
