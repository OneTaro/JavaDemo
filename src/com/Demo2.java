package com;

/**
 * Created by 灵药 on 2017/8/4.
 */
public class Demo2 {
    public static void main(String[] args) {

        Runner1 r = new Runner1();
        r.run();
//        Thread t = new Thread(r);
//        t.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("main:" + i);
        }
    }
}

class Runner1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Runner1:" + i);
        }
    }
}
