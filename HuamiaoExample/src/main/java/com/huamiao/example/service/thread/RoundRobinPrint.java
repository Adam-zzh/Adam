package com.huamiao.example.service.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author ZZH
 * @create 2023/9/12
 * @since 1.0.0
 */
public class RoundRobinPrint {

    private ReentrantLock lock = new ReentrantLock(true);
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    private volatile int number = 1;


    public void print1() throws InterruptedException {
        lock.lock();
        while (number != 1){
            condition1.await();
        }
        System.out.println("机器一开始打印");
        number = 2;
        condition2.signal();
        lock.unlock();
    }

    public void print2() throws InterruptedException {
        lock.lock();
        while (number != 2){
            condition2.await();
        }
        System.out.println("机器二开始打印");
        number = 3;
        condition3.signal();
        lock.unlock();
    }

    public void print3() throws InterruptedException {
        lock.lock();
        while (number != 3){
            condition3.await();
        }
        System.out.println("机器三开始打印");
        number = 1;
        condition1.signal();
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        RoundRobinPrint roundRobinPrint = new RoundRobinPrint();
        new  Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    roundRobinPrint.print1();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new  Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    roundRobinPrint.print2();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new  Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    roundRobinPrint.print3();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        TimeUnit.SECONDS.sleep(3);
    }

}