package Control;

import Util.Util;

import java.awt.*;

public class Difficulty {
    public boolean SWnandu() {
        if (Util.MOUSE_X > 100 && Util.MOUSE_X < 400) {
            if (Util.MOUSE_Y > 50 && Util.MOUSE_Y < 150) {
                Util.nandu = 1;
                Util.state = 0;
                return true;
            }
            if (Util.MOUSE_Y > 200 && Util.MOUSE_Y < 300) {
                Util.nandu = 2;
                Util.state = 0;
                return true;
            }
        }
        return false;
    }//判断点击
    public void paintSelf(Graphics g) {
        g.setColor(Color.black);
        g.drawRect(100, 50, 300, 100);
        Util.Word(g, "简单", 220, 100, 30, Color.black);

        g.drawRect(100, 200, 300, 100);
        Util.Word(g, "困难", 220, 250, 30, Color.black);
    }
    //绘制选项

    public void SWnandu(int nandu) {
        switch (nandu) {
            case 1:
                Util.LEI_MAX = 10;
                Util.U_W = 11;
                Util.U_H = 11;
                break;
            case 2:
                Util.LEI_MAX = 40;
                Util.U_W = 20;
                Util.U_H = 15;
            default:
        }
    }//难度
}


