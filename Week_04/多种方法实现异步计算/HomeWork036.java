package com.mk.stu.jvmstu.week04;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 基于CyclicBarrier实现
 */
public class HomeWork036 {


    private static int num = 0;


    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        long start=System.currentTimeMillis();
        int result = 0;
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        CyclicBarrier barrier = new CyclicBarrier(2);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                num = sum();
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        barrier.await();
        // 确保  拿到result 并输出
        result = num;
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
