package Gui.Game.Main;

import Gui.Game.Judeger.Judge;
import Gui.Game.Listener.ButtonBeginListener;
import Gui.Game.Listener.ButtonStopListener;
import Gui.Game.Listener.MyKeyListener;
import Gui.Game.Thread.EnemyBall;
import Gui.Game.domain.*;
import sun.security.x509.GeneralName;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class GameMainProcess {
    public static void main(String[] args) throws Exception {


        //内容面板




        //游戏区域
        GameArea gameArea=new GameArea();

        //按钮
        ButtonCompnent buttonCompnent=new ButtonCompnent();


        //飞机
        MyPlane myPlane=new MyPlane(gameArea);



        //content.add(BorderLayout.NORTH,buttonCompnent);
        //content.add(BorderLayout.CENTER,gameArea);

        //窗口
        MainInteface mainInteface=new MainInteface();
        //装载


        gameArea.add(myPlane);
        mainInteface.add(buttonCompnent);
        mainInteface.add(gameArea);








        //焦点
        gameArea.setVisible(true);
        gameArea.requestFocus();


        //绑定飞机控制事件
        gameArea.addKeyListener(new MyKeyListener(myPlane));
        mainInteface.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //敌机移动线程
        //敌机群
        EnemyPlanes enemyPlanes=new EnemyPlanes(gameArea);


        //本机子弹发射线程
        myPlane.shoot();


        //敌机子弹移动线程？？
        /*
        EnemyBall enemyBall=new EnemyBall(enemyPlane);
        Thread ballThread=new Thread(enemyBall);
        ballThread.start();

         */
        EnemyBalls enemyBalls=new EnemyBalls(enemyPlanes);

        //裁判线程
        Judge judge=new Judge(myPlane,enemyPlanes,gameArea);
        judge.check();

        //button监听
        Thread.currentThread().sleep(2000);
        buttonCompnent.stop.addActionListener(new ButtonStopListener(gameArea));
        buttonCompnent.begin.addActionListener(new ButtonBeginListener(gameArea));
         /*
        ArrayList<Thread> threads=new ArrayList();
        threads.add(enemy);
        threads.add(ballThread);
        ButtonStopListener buttonStopListener=new ButtonStopListener(threads);
        buttonCompnent.stop.addActionListener(buttonStopListener);

          */













    }
}
