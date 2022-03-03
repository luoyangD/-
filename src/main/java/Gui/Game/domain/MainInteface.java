package Gui.Game.domain;

import javax.swing.*;


public class MainInteface extends JFrame {
    public MainInteface(){
        this.setSize(600,1000);
        this.setVisible(true);
        this.setLayout(null);
        //默认位置
        this.setLocationRelativeTo(null);
        //推出程序
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //不准修改窗口大小
        this.setResizable(false);
    }
}
