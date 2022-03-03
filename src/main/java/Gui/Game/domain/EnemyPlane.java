package Gui.Game.domain;

import Gui.Game.time.TimeCaculator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class EnemyPlane extends JPanel implements Runnable{
    //public ExecutorService executorService = Executors.newFixedThreadPool(5);
    public CopyOnWriteArrayList<Ball> balls=new CopyOnWriteArrayList<Ball>();
    public GameArea gameArea;
    public Map<String,Integer> map=new HashMap<String, Integer>();
    public EnemyPlane(GameArea gameArea){
        int x=generateX_number();
        int y=generateY_number();
        map=generateWH();
        int width=map.get("width");
        int height=width;
        this.setBounds(x,y,width,height);
        this.setBackground(Color.BLUE);
        this.setVisible(true);
        this.setOpaque(false);
        this.gameArea=gameArea;

        //装弹
        int i=0;
        int j=10;
        for (i=0;i<j;i++){

            balls.add(new Ball(this,gameArea));
        }
        System.out.println("敌机子弹初始化完成");
        gameArea.add(this);
    }


    @Override
    protected void paintComponent(Graphics g) {
        //super.printComponent(g);有毒，死循环stackOver
        super.paintComponent(g);
        Image img = Toolkit.getDefaultToolkit().getImage("src\\main\\java\\Gui\\Game\\image\\enemyPlane.png");
        g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
    }


    public static int generateX_number(){
        int x_min=30;
        int x_max=550;
        int x=(int)(new Random().nextFloat()*(x_max-x_min));
        return x;
    }
    public static int generateY_number(){
        int y_min=0;
        int y_max=300;
        int y=(int)(new Random().nextFloat()*(y_max-y_min));
        return y;
    }
    public void generateEnermy(){
        int x=generateX_number();
        int y=0;
        this.setLocation(x,y);
    }
    public Map<String,Integer> generateWH(){
        int max_width=100;
        int min_width=40;
        int width=(int)(new Random().nextFloat()*(max_width-min_width));
        map.put("width",width);
        int max_height=200;
        int min_height=40;
        int height=(int)(new Random().nextFloat()*(max_height-min_height));
        map.put("height",height);
        return map;
    }
    public int generateSpeed(){
        int speed=(int)(new Random().nextFloat()*10);
        return speed;
    }


    //子弹射击线程
    /*
    public void shoot() {
        TimeCaculator timeCaculator = new TimeCaculator();
        long record = 0;
        int i = 0;
        System.out.println("子弹装载准备发射");
        while (true) {
            if (timeCaculator.caculate() % 100 == 0 && timeCaculator.caculate() != record) {
                Ball ball = balls.get(i);
                gameArea.add(ball);
                executorService.execute(ball);
                i++;
                if (i >= 5) {
                    i = 0;
                }
            }
        }
    }

     */

    //敌机移动线程
    public void run(){
        System.out.println("敌机开始移动");
        while (true){
            if(Thread.currentThread().isInterrupted()){
                break;
            }
            int speed=generateSpeed();
            //敌机移动
            int y=this.getY();
            int x=this.getX();
            //下降速度
            if(y<=1000){
                y=y+3;
                this.setLocation(x,y);
                }else{
                System.out.println("重新生成");
                this.generateEnermy();
            }
            //子弹移动
            //Ball ball=balls.get(i);
            //gameArea.add(ball);
            //executorService.execute(ball);
            //i++;
            //if(i>=10){
             //   i=0;
            //}

            try {
                Thread.currentThread().sleep(50);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
