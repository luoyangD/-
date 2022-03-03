package Gui.Game.Thread;

import Gui.Game.domain.Ball;
import Gui.Game.domain.EnemyPlane;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EnemyBall implements Runnable {
    EnemyPlane enemyPlane;

    public EnemyBall(EnemyPlane enemyPlane) {
        this.enemyPlane = enemyPlane;
    }

    public void run() {
        ExecutorService executorService= Executors.newCachedThreadPool();
        int i=0;
        while (true){
            if(Thread.currentThread().isInterrupted()){
                break;
            }
            Ball ball=enemyPlane.balls.get(i);
            enemyPlane.gameArea.add(ball);
            executorService.execute(ball);
            if (i>=10){
                i=0;
            }
            try {
                Thread.currentThread().sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
