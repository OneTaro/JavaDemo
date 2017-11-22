package com;

/**
 * Created by 灵药 on 2017/8/4.
 */
public class Demo6 {
    public static void main(String[] args) {
        MyThread3 m1 = new MyThread3("M1");
        m1.start();

        MyThread3 m2 = new MyThread3("M2");
        m2.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("I am a main");
        }
    }

}

class MyThread3 extends Thread {
    MyThread3(String s) {
        super(s);
    }

    @Override
    public void run() {
        for (int i = 1; i < 50; i++) {
            System.out.println(getName() + "：" + i);

            if (i % 2 == 0) {
                yield();
            }
        }
    }
}
