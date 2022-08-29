package com.dome.test;

import sun.plugin2.os.windows.Windows;

/**
 * @title: ThreadDome
 * @Author Wy
 * @Date: 2022/8/29 10:02
 * @Version 1.0
 */
public class ThreadDome extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadDome threadDome = new ThreadDome();
        threadDome.start();
        ThreadDome threadDome1 = new ThreadDome();
        threadDome1.run();

        int j = 0;
        //如下操作仍在main线程中执行的
        for (int i = 1; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i + "***main()***");
            } else if (j == 10) {
                Thread.sleep(100);
            }
            j++;
        }
    }

    public static void Dome1() {
        new Thread() {
            @Override
            public void run() {
                for (int i = 20; i > 0; i--) {
                    if (i % 3 == 1) {
                        System.out.println("输出" + i);
                    }
                }
            }
        }.start();
    }
}
class ThreadDome2 extends Thread{
    private static int ticket = 100;
    @Override
    public  void  run(){
        while(true){
            if(ticket > 0){
                System.out.println(getName() + ":卖票，票号为: " + ticket);
                ticket--;
            }else{
                break;
            }
        }
    }

    public static void main(String[] args) {
        
        ThreadDome2 t1 = new ThreadDome2();
        ThreadDome2 t2 = new ThreadDome2();
        ThreadDome2 t3 = new ThreadDome2();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

}