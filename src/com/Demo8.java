package com;


/**
 * Created by 灵药 on 2017/8/4.
 */
public class Demo8 implements Runnable {

    Timer timer = new Timer();

    public static void main(String[] args) {
        Demo8 demo8 = new Demo8();

        Thread t1 = new Thread(demo8);
        Thread t2 = new Thread(demo8);
        t1.setName("T1");
        t2.setName("T2");
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        timer.add(Thread.currentThread().getName());
    }
}

class Timer {
    private static int num = 0;

    public /*synchronized*/ void add(String name) {
        synchronized (this) {
            num++;

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(name + "：你是第" + num + "个使用timer的线程");
        }
    }
}