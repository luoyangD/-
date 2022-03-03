package Gui.Test;

import java.awt.*;

public class BorderLayaot {
    public static void main(String[] args) {
        Frame frame = new Frame("TestBorderLayout");

        Button buttonEast = new Button("East");
        Button buttonWest = new Button("West");
        Button buttonSouth = new Button("South");
        Button buttonNorth = new Button("North");
        Button buttonCenter = new Button("Center");

        //把按钮放置到Frame窗体时按照东西南北中五个方向排列好,推荐使用这种方式去排列窗体元素
        //这样容易检查出错误 因为这样写如果写错了编译器会提示出错

        frame.add(buttonEast, BorderLayout.EAST);
        frame.add(buttonWest, BorderLayout.WEST);
        frame.add(buttonSouth, BorderLayout.SOUTH);
        frame.add(buttonNorth, BorderLayout.NORTH);
        frame.add(buttonCenter, BorderLayout.CENTER);

        //也可以使用这样的方式排列按钮 在把按钮放置到Frame窗体时使用方向定位的字符串指定按钮的放置位置
        //这种使用方向定位的字符串指定按钮的放置方式不推荐使用 一旦写错了方向字符串就不好检查出来
        //因为即使是写错了仍然可以编译通过
        /*
        frame.add(buttonEast,"EAST");
        frame.add(buttonWest,"West");
        frame.add(buttonSouth,"South");
        frame.add(buttonNorth,"North");
        frame.add(buttonCenter,"Center");
        */

        frame.setSize(200, 200);
        frame.setVisible(true);
    }
}
