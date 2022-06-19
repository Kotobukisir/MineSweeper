package Util;

import javax.swing.*;
import java.awt.*;

//工具类
public class Util {
    public static int U_W = 40;
    public static int U_H = 40;//格子数
    public static int LEI = 36;//偏移
    public static int LENGTH = 40;//格子长度
    public static int LEI_MAX = 100;//雷
    public static int MOUSE_X;
    public static int MOUSE_Y;
    public static boolean LEFT=false;
    public static boolean RIGHT=false;
    public static int qi=0;//旗数
    public static int state = 3;//状态，0进行，1赢，2输，3选择难度
    public static int nandu;
    public static int[][] MINE = new int[U_W+2][U_H+2];//0无，-1雷，其余数字
    public static int[][] TOP = new int[U_W+2][U_H+2];//0遮盖，1旗帜，2错旗，-1空
    public static long time1;//开始时间
    public static long time2;//终止时间
    public static Image lei = Toolkit.getDefaultToolkit().getImage("D:/kecheng1/main/images/lei.png");
    public static Image top = Toolkit.getDefaultToolkit().getImage("D:/kecheng1/main/images/top.png");
    public static Image flag = Toolkit.getDefaultToolkit().getImage("D:/kecheng1/main/images/qi.png");
    public static Image death = Toolkit.getDefaultToolkit().getImage("D:/kecheng1/main/images/death.png");
    public static Image ying = Toolkit.getDefaultToolkit().getImage("D:/kecheng1/main/images/赢.png");
    public static Image shu = Toolkit.getDefaultToolkit().getImage("D:/kecheng1/main/images/输.png");
    public static Image zhong = Toolkit.getDefaultToolkit().getImage("D:/kecheng1/main/images/中.png");
    public static Image start = Toolkit.getDefaultToolkit().getImage("D:/kecheng1/main/images/start.png");
    public static Image[] images = new Image[9];
    static{
        for(int i=1;i<=8;i++){
            images[i]=Toolkit.getDefaultToolkit().getImage("D:/kecheng1/main/images/"+i+".png");
        }
    }
    public static void Word(Graphics g,String str,int x,int y,int size,Color color)
    {
        g.setColor(color);
        g.setFont(new Font("宋体",Font.BOLD,size));
        g.drawString(str, x, y);
    }
}
