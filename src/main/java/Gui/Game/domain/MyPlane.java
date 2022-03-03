package Gui.Game.domain;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//使用组合还是继承呢？
public class MyPlane extends JPanel {
    final int speed=20;
    GameArea gameArea;
    public CopyOnWriteArrayList<Ball> ballArray=new CopyOnWriteArrayList<Ball>();
    public ExecutorService executorService = Executors.newCachedThreadPool();



    public MyPlane(GameArea gameArea){
        //子弹库数量
        this.gameArea=gameArea;
        this.setBounds(300,500,100,100);
        this.setVisible(true);
        this.setOpaque(false);

        System.out.println("飞机初始化");
        int i=0;
        int j=30;
        for(i=0;i<=j;i++){
            ballArray.add(new Ball(this,gameArea));
        }
        System.out.println("本机子弹初始化完成");
    }

    @Override
    protected void paintComponent(Graphics g) {
        //super.printComponent(g);有毒，死循环stackOver
        super.paintComponent(g);
        Image img = Toolkit.getDefaultToolkit().getImage("src\\main\\java\\Gui\\Game\\image\\myplane.png");
        g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
    }

    public void upRemove(){
        int x=this.getX();
        int y=this.getY();
        if (y>speed+this.getHeight()){
            y=y-speed;
            this.setLocation(x,y);
        }
    }
    public void downRemove(){
        int x=this.getX();
        int y=this.getY();
        if (y<=(1000-speed-this.getHeight()-150)){
            y=y+speed;
            this.setLocation(x,y);
        }
    }
    public void leftRemove(){
        int x=(int)this.getX();
        int y= (int) this.getY();
        if (x>=-this.getWidth()/2){
            x=x-speed;
            this.setLocation(x,y);
        }
    }
    public void rightRemove(){
        int x=(int)this.getX();
        int y= (int) this.getY();
        if (x<(600-this.getWidth()/2)){
            x=x+speed;
            this.setLocation(x,y);
        }
    }

    public void shoot(){
       new Thread(new Runnable() {
           public void run() {
               //TimeCaculator timeCaculator=new TimeCaculator();
               //long record=0;
               int i=0;
               System.out.println("子弹装载准备发射");
               while (true){
                   if(Thread.currentThread().isInterrupted()){
                       break;
                   }
                   //if(timeCaculator.caculate()%100==0&&timeCaculator.caculate()!=record){
                   Ball ball=ballArray.get(i);
                   gameArea.add(ball);

                   //如果子弹数量很少 同一个runnable对象 别的线程也可也运行 会不会....
                   executorService.execute(ball);
                   i++;
                   if (i>=30){
                       i=0;
                   }
                   try {
                       Thread.currentThread().sleep(100);
                   } catch (InterruptedException e) {
                       Thread.currentThread().interrupt();
                       e.printStackTrace();
                   }
               }
           }
       }).start();


    }
    }

