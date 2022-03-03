package Gui.Game.domain;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class EnemyPlanes {
    public CopyOnWriteArrayList<EnemyPlane> enemyPlanes=new CopyOnWriteArrayList<EnemyPlane>();
    GameArea gameArea;
    public EnemyPlanes(GameArea gameArea){
        this.gameArea=gameArea;
        for(int i=0;i<5;i++){
            EnemyPlane enemyPlane=new EnemyPlane(gameArea);
            enemyPlanes.add(enemyPlane);
            Thread thread=new Thread(enemyPlane);
            thread.start();
        }
    }
}
