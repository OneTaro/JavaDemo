package com;

/**
 * Created by 灵药 on 2017/8/4.
 */
public class Demo7 {
    public static void main(String[] args) {
        MyThread4 thread4 = new MyThread4();
        MyThread5 thread5 = new MyThread5();

        Thread t1 = new Thread(thread4);
        Thread t2 = new Thread(thread5);

        t1.setPriority(Thread.NORM_PRIORITY + 3);

        t1.start();
        t2.start();

        System.out.println("t1线程的优先级是：" + t1.getPriority());
    }
}

class MyThread4 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("T1:" + i);
        }
    }
}

class MyThread5 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("=============T2:" + i);
        }
    }
}
