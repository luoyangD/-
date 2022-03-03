package Gui.Game.domain;

import javax.swing.*;
import java.awt.*;

public class Bomb extends JPanel {
    public Bomb(){
        setBounds(0,0,40,40);
        this.setVisible(true);
        this.setOpaque(false);
    }
    @Override
    protected void paintComponent(Graphics g) {
        //super.printComponent(g);有毒，死循环stackOver
        super.paintComponent(g);
        Image img = Toolkit.getDefaultToolkit().getImage("src\\main\\java\\Gui\\Game\\image\\bomb.png");
        g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
    }
}
