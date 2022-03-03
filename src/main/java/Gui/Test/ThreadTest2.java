package Gui.Test;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class ThreadTest2 {
    public static void main(String[] args) {
        ThreadGroup threadGroup=new ThreadGroup("A group");
        Thread t1=new Thread(threadGroup, new Runnable() {
            public void run() {
                ThreadGroup threadGroup1=Thread.currentThread().getThreadGroup();
                new Thread(new Runnable() {
                    public void run() {
                        ThreadGroup threadGroupLAST=Thread.currentThread().getThreadGroup();
                        System.out.println("t1子线程a所在线程组"+threadGroupLAST.getName());
                        System.out.println("t1子线程a所在线程组的父线程组"+threadGroupLAST.getParent().getName());
                        try {
                            Thread.currentThread().sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

                new Thread(new Runnable() {
                    public void run() {
                        ThreadGroup threadGroupLAS=Thread.currentThread().getThreadGroup();
                        System.out.println("t1子线程b所在线程组"+threadGroupLAS.getName());
                        System.out.println("t1子线程b所在线程组的父线程组"+threadGroupLAS.getParent().getName());
                        try {
                            Thread.currentThread().sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t1线程所在线程组"+threadGroup1.getName());
                System.out.println("t1线程所在线程组的父线程组"+threadGroup1.getParent().getName());

            }
        },"t1");
        t1.start();


        //测试:所有线程都在main线程组，哪怕被重新分组了；
        ThreadGroup threadGroup2=Thread.currentThread().getThreadGroup();
        System.out.println("主线程组main存活数量"+threadGroup2.activeCount());

        int num=threadGroup2.activeCount();
        System.out.println("main线程组存活数量"+num);



        Thread [] threads=new Thread[3];
        threadGroup2.enumerate(threads);
        for(Thread thread:threads){
            System.out.println("main线程组各线程名:"+thread.getName());
        }


    }
}
