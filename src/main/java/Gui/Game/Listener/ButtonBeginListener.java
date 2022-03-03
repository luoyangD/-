package Gui.Game.Listener;

import Gui.Game.domain.GameArea;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonBeginListener implements ActionListener {
    ThreadGroup threadGroup=null;
    GameArea gameArea;


    public ButtonBeginListener(GameArea gameArea) {
        this.gameArea=gameArea;

    }
    public void actionPerformed(ActionEvent e) {
        System.out.println("启动游戏按钮监听器启动");
        threadGroup=Thread.currentThread().getThreadGroup();
        Thread [] threads=new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        for (Thread  thread:threads){
//            try {
//                System.out.println(thread.isInterrupted());
//                //通过睡眠抛异常重置中断标志 由于是静态方法 无效果 interruped同理不起作用
//
//                System.out.println(thread.isInterrupted());
//            } catch (InterruptedException interruptedException) {
//                interruptedException.printStackTrace();
//            }
        }
        gameArea.requestFocus();
    }
}
