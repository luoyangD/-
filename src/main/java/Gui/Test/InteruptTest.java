package Gui.Test;

public class InteruptTest {
    public static void main(String[] args) {
        final int i=10;
        final Thread thread=new Thread(new Runnable() {
            public void run() {
                Thread.currentThread().interrupt();
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("do nothing");
            }
        });
//        thread.start();
//        thread.interrupt();
        thread.start();

        try {
            //thread.sleep只能在所在的线程内布使用，外部使用没用的，只能让当前线程睡
            thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("sleep 1s");



    }
}
