package com.blockingqueuedome.BlockingQueueTests;

import org.junit.Test;

import java.util.Deque;
import java.util.concurrent.*;

/**
 * @title: BlockingQueueTestsDome
 * @Author Wy
 * @Date: 2022/8/23 13:42
 * @Version 1.0
 */
public class BlockingQueueTestsDome1 {
    /**
     * 一、阻塞队列 添加元素有四种方式
     * 1、add()  ====>  如果插入成功则返回 true，否则抛出 IllegalStateException 异常
     * 2、put()  ====>  将指定的元素插入队列，如果队列满了，那么会阻塞直到有空间插入
     * 3、offer() ====> 如果插入成功则返回 true，否则返回 false
     * 4、offer(E e, long timeout, TimeUnit unit) ====>试将元素插入队列，如果队列已满，那么会阻塞直到有空间插入
     * <p>
     * <p>
     * 二、阻塞队列 提取有两种方式
     * 1、take:获取队列的头部元素并将其删除，如果队列为空，则阻塞并等待元素变为可用
     * 2、poll:检索并删除队列的头部，如有必要，等待指定的等待时间以使元素可用，如果超时，则返回 null
     */


    /**
     *  BlockingQueue 在offer 添加一个null 时，会抛出一个异常
     * 如果添加时，超出长度会返回一个false 主要针对ArrayBlockingQueue
     */
    @Test
    public void test() {
//      LinkedBlockingQueueDome();
        ArrayBlockingQueueDome();
    }


    /**
     * 由数组支持的有界队列
     */
    private BlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
    /**
     * 由链接节点支持的可选有界队列
     */
    private BlockingQueue linkBlockingQueue = new LinkedBlockingQueue();
    /**
     * 由优先级堆支持的无界优先级队列
     */
    private BlockingQueue priorityBlockingQueue = new PriorityBlockingQueue();
    /**
     * 由优先级堆支持的、基于时间的调度队列
     */
    private BlockingQueue delayQueue = new DelayQueue();

    /**
     * 队列基于数组实现,容量大小在创建ArrayBlockingQueue对象时已定义好数据结构
     * 基于ReentrantLock保证线程安全，根据Condition实现队列满时的阻塞
     */
    private static void ArrayBlockingQueueDome() {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        boolean  s1=blockingQueue.offer("sssss1");
        boolean  s2=blockingQueue.offer("sssss2");
        boolean  s3=blockingQueue.offer("sssss3");
        boolean  s4=blockingQueue.offer("sssss4");
        for (int i=0;i<4;i++){
            try {
                String take = blockingQueue.take();
                String poll = blockingQueue.poll();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        System.out.println(blockingQueue);
    }

    /**
     * 是一个基于链表的无界队列(无上界)
     */
    private static void LinkedBlockingQueueDome() {
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();
        for (int i = 0; i < 20; i++) {
            if (i == 10) {
               try {
                boolean offer = blockingQueue.offer(null);
                System.out.println(offer);
               }catch (Exception e){
                   System.out.println(e);
               }
               finally {
                   break;
               }
            }
            blockingQueue.offer("sssss" + i);
        }
        System.out.println(blockingQueue);
    }

    /**
     * 由优先级堆支持的、基于时间的调度队列，
     * 内部基于无界队列PriorityQueue实现，而无界队列基于数组的扩容实现。
     * 入队的对象必须要实现Delayed接口,而Delayed集成自Comparable接口
     */
    private static void DelayQueue() {
        BlockingQueue<String> blockingQueue = new DelayQueue();
    }


}
