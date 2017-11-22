package com;

/**
 * 使用递归计算第5个斐波那契数列数
 * Created by 灵药 on 2017/8/4.
 */
public class Demo1 {
    public static void main(String[] args) {
        System.out.println(f(5));
        System.out.println(f1(5));
    }

    public static int f(int i) {
        if (i == 1 || i == 2) {
            return 1;
        } else {
            return f(i-1) + f(i-2);
        }
    }

    public static int f1(int i) {
        if (i == 1 || i == 2) {
            return 1;
        } else {
            return f1(i-1) * f1(i-2);
        }
    }
}
