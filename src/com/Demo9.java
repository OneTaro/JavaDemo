package com;

/**
 * Created by 灵药 on 2017/8/4.
 */
public class Demo9 implements Runnable {

    public int flag = 1;
    static Object o1 = new Object(), o2 = new Object();

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "的flag=" + flag);

        if (flag == 1) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (o2) {
                    System.out.println("1");
                }
            }
        }

        if (flag == 0) {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (o1) {
                    System.out.println("0");
                }
            }
        }
    }

    public static void main(String[] args) {
        Demo9 d1 = new Demo9();
        Demo9 d2 = new Demo9();
        d1.flag = 1;
        d2.flag = 0;

        Thread t1 = new Thread(d1);
        Thread t2 = new Thread(d2);

        t1.setName("线程t1");
        t2.setName("线程t2");

        t1.start();
        t2.start();
    }

}