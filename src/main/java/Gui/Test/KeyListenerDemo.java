package Gui.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListenerDemo {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            JFrame frame = new JFrame("窗口程序");//创建一个带标题的窗口对象frame
            frame.setVisible(true);//显示窗口
            frame.setSize(600, 400);//设置窗口大小
            frame.setLocationRelativeTo(null);//设置窗口居中
            frame.setDefaultCloseOperation(3);//点击X关闭程序  3为结束程序
            frame.setLayout(null);//清空布局
            Button button = new Button("按钮");
            button.setBounds(100,100,100,50);
            button.setBackground(Color.ORANGE);
            MyKeyListener myKeyListener = new MyKeyListener(button);//创建一个键盘监听事件对象
            frame.addKeyListener(myKeyListener);//添加myKeyListener键盘监听事件
            frame.add(button);
        }

    }
    class MyKeyListener  implements KeyListener {

        private Button button;

        public MyKeyListener(Button button) {
            super();
            this.button = button;
        }


        public void keyTyped(KeyEvent e) {
            // TODO Auto-generated method stub

        }

        //每按下一个任意键盘，此方法都会自动调用一次

        public void keyPressed(KeyEvent e) {
            // TODO Auto-generated method stub

            /*
             * 监听键盘上下左右键，改变按钮的坐标
             */
            int keyCode = e.getKeyCode();//获取所按键盘的键盘编码

            int x = button.getX();//获取按钮当前的横坐标值
            int y = button.getY();//获取按钮当前的纵坐标值
            int width = button.getWidth();//获取按钮当前的宽
            int height = button.getHeight();//获取按钮当前的高

            if (keyCode == KeyEvent.VK_UP) {  //KeyEvent.VK_UP上键编码
                button.setBounds(x, y-20, width, height);
            }else if (keyCode == KeyEvent.VK_DOWN) {  //下键
                button.setBounds(x, y+20, width, height);
            }else if (keyCode == KeyEvent.VK_LEFT) {  //左键
                button.setBounds(x-20, y, width, height);
            }else if (keyCode == KeyEvent.VK_RIGHT) {  //右键
                button.setBounds(x+20, y, width, height);
            }
        }


        public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub

        }

    }


