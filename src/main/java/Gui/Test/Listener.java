package Gui.Test;

import java.awt.*;
import java.awt.event.*;

public class Listener {
    public static void main(String[] args) {
        Frame frame=new Frame();
        frame.setLayout(new FlowLayout());
        frame.setSize(500,1000);
        Button button=new Button("button");
        frame.add(button);
        frame.setVisible(true);

        // 给按钮绑定事件
        ButtonListener buttonListener=new ButtonListener();
        button.addActionListener(buttonListener);

        //给窗口绑定事件
        //WindowListener windowListener=new MyWindowAdapter();
        //frame.addWindowListener(windowListener);

        //使用匿名内部类的写法
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

}

//重写绑定事件
class ButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
        System.out.println("按钮被按下");
    }
}

/*
class MyWindowAdapter extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}

 */
