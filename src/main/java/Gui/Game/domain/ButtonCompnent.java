package Gui.Game.domain;

import Gui.Game.Listener.ButtonStopListener;

import javax.swing.*;
import java.awt.*;


public class ButtonCompnent extends JPanel {
    public  JButton begin;
    public  JButton stop;
    public  JButton gameOver;
    public  JButton grade;
    public ButtonCompnent(){
        this.setLayout(new FlowLayout(FlowLayout.CENTER,20,40));
        this.setSize(600,70);
        this.setBackground(Color.GREEN);
        this.setVisible(true);
        this.setLocation(0,0);

        begin= new JButton("Begin");
        stop=new JButton("Stop");
        gameOver=new JButton("GameOver");
        grade=new JButton("Grade");


        this.add(begin);
        this.add(stop);
        this.add(gameOver);
        this.add(grade);
        this.setVisible(true);
    }

}
