package Gui.Test;

public class ThreadSleepTest {
    public static void main(String[] args) {

        ThreadGroup groupA=new ThreadGroup("A组");
        final ThreadGroup groupB=new ThreadGroup("B组");
        ThreadGroup groupC=new ThreadGroup("C组");
        final Thread t4=new Thread(groupB,new Runnable() {
            public void run() {
                while (true){
                    int a=0;
                }
            }
        });

        Thread t1=new Thread(groupA,new Runnable() {
            public void run() {
                t4.start();

            }
        },"t1");
        Thread t2=new Thread(groupB,new Runnable() {
            public void run() {
                Thread T5=new Thread(new Runnable() {
                    public void run() {
                        while (true){
                            int a=0;
                        }
                    }
                },"t2");
                T5.start();
                System.out.println("t5 group name:"+T5.getThreadGroup().getName());
                System.out.println("t5 group father name:"+T5.getThreadGroup().getParent());
                ThreadGroup threadGroup1=T5.getThreadGroup();
                Thread [] threads=new Thread[threadGroup1.activeCount()];
                System.out.println(threadGroup1.activeCount());
                for (Thread thread:threads){
                    System.out.println("B组子线程:"+thread.getName());
                }

            }
        });
        Thread t3=new Thread(groupC,new Runnable() {
            public void run() {
                while (true){
                    int a=0;
                }
            }
        },"t3");
        Thread t6=new Thread(groupC,new Runnable() {
            public void run() {
                while (true){
                    int a=0;
                }
            }
        },"t3");

        t1.start();
        t6.start();
        System.out.println("t6 group father name:"+t6.getThreadGroup().getParent());
        t2.start();
        t3.start();
        System.out.println("t4 group name:"+t4.getThreadGroup().getName());
        System.out.println("t4 group father name:"+t4.getThreadGroup().getParent());


        System.out.println("主线程线程组及子线程组:"+Thread.currentThread().getThreadGroup().activeGroupCount());
        try {
            t1.sleep(5000);
            t2.sleep(5000);
            t1.interrupt();
            t2.interrupt();
            System.out.println("?");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




        ThreadGroup threadGroup=Thread.currentThread().getThreadGroup();
        Thread [] threads=new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        for (Thread  thread:threads){

            System.out.println();
            System.out.println("main线程组包含线程"+thread.getName());
            System.out.println("main线程组各线程父线程"+thread.getThreadGroup().getParent().getName());
        }
        for (Thread  thread:threads){
            thread.interrupt();
            System.out.println(thread.getName());
        }
        System.out.println("main线程醒来吗？");



        //线程在哪定义就属于哪个线程组，如果自定义线程组，那么将属于自定义线程组，同时也是前者的子线程

    }

}
