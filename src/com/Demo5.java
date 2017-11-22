package com;

/**
 * Created by 灵药 on 2017/8/4.
 */
public class Demo5 {
    public static void main(String[] args) {
        MyThread2 mt = new MyThread2("thread2");
        mt.start();

        try {
            mt.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("I am main Thread");
        }
    }
}

class MyThread2 extends Thread {
    MyThread2(String s) {
        super(s);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("I am a\t" + getName());
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
