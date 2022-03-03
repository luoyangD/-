package Gui.Game.Listener;

import Gui.Game.domain.ButtonCompnent;
import Gui.Game.domain.GameArea;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ButtonStopListener implements ActionListener {
    ThreadGroup threadGroup=null;
    GameArea gameArea;

    public ButtonStopListener(GameArea gameArea) {
        this.gameArea=gameArea;
    }


    public void actionPerformed(ActionEvent e) {
        System.out.println("鼠标暂停，听见！");
        threadGroup=Thread.currentThread().getThreadGroup();

        final Thread [] threads=new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        //Date date=new Date();
        //DateFormat dateFormat=DateFormat.getDateTimeInstance();
        //System.out.println("存活线程："+threadGroup.activeCount());
        //System.out.println("线程开始暂停时间:"+dateFormat.format(date));
        for (Thread  thread:threads){
            //if(thread.getName()!="main")
            //thread.sleep(1000);
            thread.interrupt();


            //静态方法 主线程也会睡眠
            //thread.sleep(10000);
            //System.out.println("预备睡眠的线程："+thread.getName());
            //System.out.println(dateFormat.format(date));

        }

        gameArea.requestFocus();

        //System.out.println("全部线程暂停时间"+dateFormat.format(date));
    }
}
