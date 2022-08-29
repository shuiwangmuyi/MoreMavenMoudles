package com.dome.test;

/**
 * @title: ThreadPool
 * @Author Wy
 * @Date: 2022/8/29 14:51
 * @Version 1.0
 */

import java.util.concurrent.*;

/**
 * 创建多线程的方式四：使用线程池
 * <p>
 * 好处：
 * 1.提高响应速度（减少了创建新线程的时间）
 * 2.降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 * 3.便于线程管理
 * corePoolSize：核心池的大小
 * maximumPoolSize：最大线程数
 * keepAliveTime：线程没有任务时最多保持多长时间后会终止
 * <p>
 * 面试题：创建多线程有几种方式？四种！
 */

class NumberThread implements Runnable {
    private CountDownLatch countDownLatch;

    public NumberThread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i <= 100; i++) {
                if (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //减一
            countDownLatch.countDown();
        }
    }
}

class NumberThread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

/**
 * 线性池
 */
public class ThreadPool {


    public static void main(String[] args) {
        int threadNum = 10;

        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        //提供指定线程数量的线程池
        ExecutorService executor = Executors.newFixedThreadPool(threadNum);
        for (int i = 0; i < 100; i++) {
            executor.execute(new NumberThread(countDownLatch));
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //3.关闭连接池
            executor.shutdown();
        }

//        ExecutorService executor1 = Executors.newFixedThreadPool(8);
//        //新线程并添加到池中。终止并从缓存中移除那些已有 60 秒钟未被使用的线程。
//        ExecutorService executor2 = Executors.newCachedThreadPool();
//
//        //创建一个单线程化的Executor
//        ExecutorService executor3 = Executors.newSingleThreadExecutor();
//
//        //创建一个支持定时及周期性的任务执行的线程池，多数情况下可用来替代Timer类
//        ScheduledExecutorService executor4 = Executors.newScheduledThreadPool(8);


    }
}
