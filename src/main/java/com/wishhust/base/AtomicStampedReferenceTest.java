package com.wishhust.base;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceTest {

    private static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 0);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
                boolean result = atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
                System.out.println("t11"+result);

                boolean result2 = atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
                System.out.println("t12"+result2);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        Thread t2 = new Thread(()->{
            try {
                int stamp = atomicStampedReference.getStamp();
                System.out.println("Before sleep: stamp="+stamp);
                TimeUnit.SECONDS.sleep(2);
                boolean result = atomicStampedReference.compareAndSet(100, 101, stamp, stamp + 1);
                System.out.println("t2"+result);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();


    }
}
