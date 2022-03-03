package Gui.Game.domain;

import Gui.Game.Thread.EnemyBall;

import java.util.ArrayList;

public class EnemyBalls {
    EnemyPlanes enemyPlanes;
    public EnemyBalls(EnemyPlanes Planes){
        this.enemyPlanes=Planes;
        for (int i=0;i<Planes.enemyPlanes.size();i++){
            EnemyBall enemyBall=new EnemyBall(Planes.enemyPlanes.get(i));
            Thread thread=new Thread(enemyBall);
            thread.start();
        }
    }

}
