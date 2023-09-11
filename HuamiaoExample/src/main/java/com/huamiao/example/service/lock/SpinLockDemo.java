package com.huamiao.example.service.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author 邱润泽 bullock
 */
public class SpinLockDemo {

    private AtomicReference atomicReference = new AtomicReference<Thread>();

    private volatile static SpinLockDemo spinLockDemo;

    private SpinLockDemo(){}

    public static SpinLockDemo getInstance(){
        if (spinLockDemo == null){
            synchronized (SpinLockDemo.class){
                if (spinLockDemo == null) spinLockDemo = new SpinLockDemo();
            }
        }
        return spinLockDemo;
    }

    private void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "开始获取锁");
        while (!atomicReference.compareAndSet(null, thread)){

        }
        System.out.println(thread.getName() + "获得锁成功");
    }

    private  void unLock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(thread.getName() + "释放了锁");
    }

    public static void main(String[] args) throws InterruptedException {
        SpinLockDemo spinLockDemo = SpinLockDemo.getInstance();
        Thread thread = new Thread(() -> {
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            spinLockDemo.unLock();
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);

        Thread thread1 = new Thread(() -> {
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            spinLockDemo.unLock();
        });
        thread1.start();

        thread.join();
        thread1.join();
    }
}
