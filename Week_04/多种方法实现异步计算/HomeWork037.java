package com.mk.stu.jvmstu.week04;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 基于阻塞队列实现
 */
public class HomeWork037 {

    private static int num = 0;

    public static void main(String[] args) throws InterruptedException {

        long start=System.currentTimeMillis();
        int result =0;
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                num = sum();
                try {
                    queue.put(num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(">>>>>>>>>>>计算结束："+num);
            }
        }).start();

        result = queue.take();
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }

    private static int sum() {
        return fibo(45);
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}
