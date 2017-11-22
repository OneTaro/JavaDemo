package com;

import java.util.Date;

/**
 * Created by 灵药 on 2017/8/4.
 */
public class Demo4 {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.start();

        try {
            MyThread.sleep(10000);
            System.out.println("主线程睡眠了10秒种后再次启动了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mt.flag = false;
    }
}

class MyThread extends Thread {
    boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            System.out.println("==========" + new Date().toLocaleString() + "===========");

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
