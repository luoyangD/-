package Gui.Game.domain;

import javax.swing.*;
import java.awt.*;

public class GameArea extends JPanel {
    public GameArea(){
        this.setVisible(true);
        this.setLayout(null);
        this.setBounds(0,70,600,930);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image background = Toolkit.getDefaultToolkit().getImage("src\\main\\java\\Gui\\Game\\image\\gameArea.jpg");
        g.drawImage(background,0,0,this.getWidth(),this.getHeight(),null);
    }
}
