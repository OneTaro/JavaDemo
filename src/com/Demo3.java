package com;

/**
 * Created by 灵药 on 2017/8/4.
 */
public class Demo3 {
    public static void main(String[] args) {
        Runner2 r = new Runner2();
        r.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main:" + i);
        }
    }
}

class Runner2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Runner2:" + i);
        }
    }
}