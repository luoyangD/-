package Gui.Game.Judeger;


import Gui.Game.Thread.EnemyBall;
import Gui.Game.domain.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Judge extends JPanel{
    public Bomb bomb=new Bomb();
    public MyPlane myPlane;
    public EnemyPlanes Planes;
    public GameArea gameArea;
    public Judge(MyPlane myPlane,EnemyPlanes enemyPlanes,GameArea gameArea){
        this.myPlane=myPlane;
        this.Planes=enemyPlanes;
        this.gameArea=gameArea;
    }

    public void check() {
        new Thread(new Runnable() {
            public void run() {
                System.out.println("裁判线程启动");
                //判断敌机爆炸，我方子弹打到敌机上
                for (int j=0;j<Planes.enemyPlanes.size();j++){
                    EnemyPlane enemyPlane=Planes.enemyPlanes.get(j);
                    for (int i=0;i<myPlane.ballArray.size();i++){


                        Ball ball=myPlane.ballArray.get(i);
                        int ball_width=ball.getWidth();
                        int ball_height=ball.getHeight();
                        int ball_x=ball.getX();
                        int ball_y=ball.getY();
                        //获取子弹的中心
                        float ballCenter_x=(float)(ball_x+0.5*ball_width);
                        float ballCenter_y=(float)(ball_y+0.5*ball_height);
                        //获取敌机中心点
                        float enemyCenter_x=(float)(enemyPlane.getX()+0.5*enemyPlane.getWidth());
                        float enemyCenter_y=(float)(enemyPlane.getY()+0.5*enemyPlane.getHeight());
                        //计算差值
                        float deltaX=Math.abs(ballCenter_x-enemyCenter_x);
                        float deltaY=Math.abs(ballCenter_y-enemyCenter_y);
                        //计算对比矩形
                        float X=(float)0.5*(ball_width+enemyPlane.getWidth());
                        float Y=(float)0.5*(ball_height+enemyPlane.getHeight());

                        if (deltaX<=X&&deltaY<=Y){
                            //设定爆炸位置
                            //System.out.println("敌机被击中");
                            bomb.setLocation(enemyPlane.getX(),enemyPlane.getY());
                            gameArea.add(bomb);
                            enemyPlane.generateEnermy();
                            try {
                                Thread.currentThread().sleep(50);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            gameArea.remove(ball);
                            gameArea.remove(bomb);

                        }
                        if (j>=Planes.enemyPlanes.size()-1){
                            j=0;
                        }
                    }

                }
                System.out.println("裁判线程结束");


                //判断本机爆炸
            }
        }).start();

    }
}
