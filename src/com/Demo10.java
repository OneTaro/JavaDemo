package com;

/**
 * Created by 灵药 on 2017/8/4.
 */
public class Demo10 {
    public static void main(String[] args) {
        SyncStack stack = new SyncStack();
        Runnable p = new Producer(stack);
        Runnable c = new Customer(stack);

        Thread p1 = new Thread(p);
        Thread c1 = new Thread(c);

        p1.start();
        c1.start();
    }
}

class SyncStack {
    private int index = 0;
    private char data[] = new char[6];

    public synchronized void push(char c) {
        if (index == data.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }

            this.notify();
            data[index] = c;
            index++;
        }
    }

    public synchronized char pop() {
        if (index == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {

            }
            this.notify();
            index--;
        }
        return data[index];
    }
}

class Producer implements Runnable {

    SyncStack ss;

    public Producer(SyncStack s) {
        ss = s;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            char c = (char) (Math.random() * 26 + 'A');
            ss.push(c);
            System.out.println("produced："+c);

            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
            }
        }
    }
}

class Customer implements Runnable {

    SyncStack ss;
    public Customer(SyncStack s) {
        ss = s;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            char c = ss.pop();
            System.out.println("消费：" + c);

            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
            }
        }
    }
}