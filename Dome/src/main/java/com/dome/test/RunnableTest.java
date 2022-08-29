package com.dome.test;

/**
 * @title: RunnableDome
 * @Author Wy
 * @Date: 2022/8/29 11:12
 * @Version 1.0
 */
public class RunnableTest {
    public static void main(String[] args) {
        RunnableDome1 dome1 = new RunnableDome1();
        for (int i = 0; i < 10002; i++) {
            Thread t1 = new Thread(dome1);
            t1.setName("TEST" + i);
            t1.start();
        }

//        RunnableDome dome1=new RunnableDome();
//        Thread t1 = new Thread(dome1);
//        t1.start();
//
//        RunnableDome dome2=new RunnableDome();
//        Thread t2=new Thread(dome2);
//        t2.setName("线程2");
//        t2.start();
    }

}

class RunnableDome1 implements Runnable {
    private int tick = 1000000;

    @Override
    public void run() {
        while (true) {
            methods2();
        }
//        methods1();
    }

    private synchronized void methods2() {
        if (tick > 0) {
            if (tick / 2 == 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(Thread.currentThread().getName() + ":卖票，票号为: " + tick);
            tick--;
        } else {
            System.out.println("break");
            try {
             //   Thread.sleep(100000000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
//        if (tick>0){
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println(Thread.currentThread().getName() + ":卖票，票号为: " + tick);
//            tick--;
//        }
    }

    public void methods1() {

        while (true) {
            synchronized (this) {
                if (tick > 0) {
                    if (tick / 2 == 0) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为: " + tick);
                    tick--;
                } else {
                    System.out.println("break");
                    break;
                }
            }
        }
    }
}

class RunnableDome implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            if (i == 20) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
