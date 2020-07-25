package com.wishhust.base;

import java.util.concurrent.atomic.AtomicInteger;

public class RateLimiter {
    /**
     * 实现一个单机限流器，要求每秒钟只能通过100个请求。也就是限制QPS<=100。
     */

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static boolean tryAcquire() {

        //TODO
//        if (atomicInteger.compareAndSet())

        return false;

    }

    public static void main(String[] args) {

        int i = 1;

        while (true) {

            if (!tryAcquire()) {

                System.out.println("Count:" + i);

                break;

            }

            i++;

        }

    }
}
