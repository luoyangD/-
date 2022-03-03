package Gui.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
    public static void main(String[] args) {
        Thread t1=new Thread(new Runnable() {
            public void run() {
                for(int i=0;i<10;i++){
                    new Thread(new Runnable() {
                        public void run() {
                            int a=1;
                            try {
                                Thread.currentThread().sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            ThreadGroup threadGroupt=Thread.currentThread().getThreadGroup();
                            String name=threadGroupt.getName();
                            ThreadGroup parent=threadGroupt.getParent();
                            //System.out.println("父线程组名字："+parent.getName());//默认所有线程的父线程组是system
                            //System.out.println("t1线程的子线程的当前线程组活跃线程数量:"+threadGroupt.activeCount());

                            //System.out.println("t1线程的子线程的当前线程组:"+name);;//默认所有线程都在main线程组
                        }

                    }).start();
                }
                ThreadGroup threadGroup=Thread.currentThread().getThreadGroup();
                System.out.println("t1线程当前线程组活跃线程数量:"+threadGroup.activeCount());
            }
        });
        t1.setName("A");
        Thread t2=new Thread(new Runnable() {
            public void run() {
                ExecutorService executorService= Executors.newFixedThreadPool(10);
            }
        });
        t2.setName("B");

        t1.start();;
        t2.start();

        //测试

        ThreadGroup threadGroup=Thread.currentThread().getThreadGroup();
        try {
            Thread.currentThread().sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int num=threadGroup.activeCount();
        System.out.println("main线程组存活数量"+num);

        Thread [] threads=new Thread[12];
        threadGroup.enumerate(threads);
        for(Thread thread:threads){
            System.out.println("main线程组各线程名:"+thread.getName());
        }



    }
}
