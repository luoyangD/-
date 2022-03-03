package Gui.Test;

import javafx.scene.layout.Pane;

import java.awt.*;

public class TestForGui {
    public static void main(String[] args) {
        Frame frame=new Frame();
        //布局管理器需要设置为null
        frame.setLayout(null);
        frame.setBackground(Color.GRAY);
        frame.setVisible(true);
        frame.setSize(500,1000);
        frame.setLocation(200,200);



        Panel panel=new Panel(null);
        frame.add(panel);

        panel.setBounds(50,50,100,100);
        panel.setBackground(Color.BLUE);


    }
}
