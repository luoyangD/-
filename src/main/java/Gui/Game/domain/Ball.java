package Gui.Game.domain;

import javax.swing.*;
import java.awt.*;

public class Ball extends JPanel implements Runnable{
    int speed=5;
    GameArea gameArea;
    JPanel panel;
    final int width=10;
    final int height=30;
    final Color color=Color.red;
    public Ball(){
        this.setSize(width,height);
        this.setVisible(true);
        this.setOpaque(false);
    }
    public Ball(JPanel panel,GameArea gameArea) {
        this.gameArea=gameArea;
        this.panel = panel;
        int x=panel.getX()+panel.getWidth()/2;
        int y=panel.getY();
        this.setBounds(x,y,10,30);
        this.setSize(width,height);
        this.setVisible(true);
        this.setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        //super.printComponent(g);有毒，死循环stackOver
        super.paintComponent(g);
        Image img = Toolkit.getDefaultToolkit().getImage("src\\main\\java\\Gui\\Game\\image\\ball.png");
        g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
    }



    //重置定位
    public void fixPosition(){
        int x=(int)panel.getX()+(panel.getWidth()-this.getWidth())/2;
        int y=panel.getY();
        this.setLocation(x,y);
    }


    public void move(){

         /*
        this.fixPosition();
        TimeCaculator caculator=new TimeCaculator();
        long record=0;
        while (true){
            if (caculator.caculate()%10==0&&caculator.caculate()!=record){
                record=caculator.caculate();
                int x=this.getX();
                int y=this.getY();
                if(y>=0){
                    y=y-speed;
                    this.setLocation(x,y);
                }else {
                    gameArea.remove(this);
                    break;
                }
            }
        }

          */



    }
    /*
    public void run() {
        this.move();
        while (true)
        try {
            Thread.currentThread().sleep(10);
            this.move();
            int y=this.getY();
            if (y==0){
                System.out.println("抵达顶点");
                break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

     */
    public void run(){
        this.fixPosition();
        int x=this.getX();
        int y=this.getY();
        if (panel instanceof EnemyPlane) {
            while (true) {
                if(Thread.currentThread().isInterrupted()){
                    System.out.println(Thread.currentThread().isInterrupted());
                    break;
                }
                if (y <= 1000) {
                    y = y + speed;
                    this.setLocation(x, y);
                } else {
                    gameArea.remove(this);
                    break;
                }
                try {
                    Thread.currentThread().sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        }else{

             while (true){
                 if(Thread.currentThread().isInterrupted()){
                     break;
                 }
                if(y>=0){
                    y=y-speed;
                    this.setLocation(x,y);
                }else {
                    gameArea.remove(this);
                    break;
                }
                try {
                    Thread.currentThread().sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        }
    }
}
