package Gui.Game.Listener;

import Gui.Game.domain.MyPlane;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {
    MyPlane myPlane;

    public MyKeyListener(MyPlane myPlane) {
        super();
        this.myPlane = myPlane;
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        System.out.println("键盘监听，已听见！");
        int keyCode=e.getKeyCode();
        int x=myPlane.getX();
        int y=myPlane.getY();
        int width=myPlane.getWidth();
        int height=myPlane.getHeight();
        if (keyCode==KeyEvent.VK_UP){
            myPlane.upRemove();
        }
        if (keyCode==KeyEvent.VK_DOWN){
            myPlane.downRemove();
        }
        if (keyCode==KeyEvent.VK_LEFT){
            myPlane.leftRemove();
        }
        if (keyCode==KeyEvent.VK_RIGHT){
            myPlane.rightRemove();
        }
    }

    public void keyReleased(KeyEvent e) {



    }
}
