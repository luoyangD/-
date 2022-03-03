package Gui.Test;

import java.awt.*;

public class Flowlayout {
    public static void main(String[] args) {
        Frame frame=new Frame();
        //使用布局管理器时，布局管理器负责各个组建的大小和位置，因此用户无法在这种情况下设置组件大小和维位置属性，如果试图使用Java语言
        // 提供的setLocation(),setSize(),setBounds()等方法，则都会被布局管理器覆盖。
        frame.setLayout(new FlowLayout(FlowLayout.LEFT,20,40));
        frame.setSize(200,200);
        Button button01=new Button("button1");
        Button button02=new Button("button2");
        Button button03=new Button("button3");
        Button button04=new Button("button4");
        frame.add(button01);
        frame.add(button02);
        frame.add(button03);
        frame.add(button04);
        frame.setVisible(true);



    }
}
