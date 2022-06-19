package Main;

import Control.Difficulty;
import Display.Surface;
import Display.LnnerLayer;
import Util.Util;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class GameMain extends JFrame {

    Image connect = null;
    Image caidan = null;
    //双缓存
    int width = 2* Util.LEI + Util.U_W * Util.LENGTH;
    int height = 4*Util.LEI + Util.U_H * Util.LENGTH;
    LnnerLayer LnnerLayer = new LnnerLayer();
    Surface Surface = new Surface();
    Difficulty difficulty = new Difficulty();
    boolean begin=false;
    void launch(){
        this.setVisible(true);
        if(Util.state==3)//难度选择窗口
        {
            this.setSize(500,350);
        }
        else//游戏窗口
        {
            this.setSize(width,height);
        }
        this.setLocationRelativeTo(null);
        this.setTitle("扫雷游戏");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Util.time1=System.currentTimeMillis();

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                switch (Util.state)
                {
                    case 0:
                        if(e.getButton()==1)
                        {
                            Util.MOUSE_X = e.getX();
                            Util.MOUSE_Y = e.getY();
                            Util.LEFT = true;
                        }
                        if(e.getButton()==3)
                        {
                            Util.MOUSE_X = e.getX();
                            Util.MOUSE_Y = e.getY();
                            Util.RIGHT = true;
                        }
                    case 1:
                    case 2:
                        if(e.getButton()==1)
                        {
                            if(e.getX()>Util.LEI+Util.LENGTH*(Util.U_W/2)&&
                                    e.getX()<Util.LEI+Util.LENGTH*(Util.U_W/2)+Util.LENGTH&&
                            e.getY()>Util.LEI&&
                            e.getY()<Util.LEI+Util.LENGTH)
                            {
                                LnnerLayer.restart();
                                Surface.restart();
                                Util.qi=0;
                                Util.state=0;
                                Util.time1=System.currentTimeMillis();
                            }
                        }
                        if(e.getButton()==2)
                        {
                            Util.state=3;
                            begin = true;
                        }
                        break;
                    case 3:
                        if(e.getButton()==1)
                        {
                            Util.MOUSE_X = e.getX();
                            Util.MOUSE_Y = e.getY();
                            begin = difficulty.SWnandu();
                        }
                    default:

                }
            }
        });



        while(true){
            repaint();
            begin();
        }
    }

    @Override
    public void paint(Graphics g)//双缓冲绘制画布
    {

        if(Util.state==3)
        {
            caidan = this.createImage(500,350);
            Graphics gImage = caidan.getGraphics();
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(0,0,500,350);
            difficulty.paintSelf(gImage);
            g.drawImage(caidan,0,0,null);
        }else
        {
            connect = this.createImage(width, height);
            Graphics huabi1 = connect.getGraphics();
            huabi1.setColor(Color.white);
            huabi1.fillRect(0, 0, width, height);
            LnnerLayer.paintSelf(huabi1);
            Surface.paintSelf(huabi1);
            g.drawImage(connect, 0, 0, null);
        }
    }
    public static void main(String[] args)
    {
        GameMain gameMain = new GameMain();
        gameMain.launch();
    }

    public void begin()//重置
    {
        if(begin)
        {
            begin=false;
            difficulty.SWnandu(Util.nandu);
            GameMain gameMain = new GameMain();
            dispose();
            Util.time1=System.currentTimeMillis();
            Surface.restart();
            LnnerLayer.restart();
            Util.qi=0;
            gameMain.launch();
        }
    }
}
