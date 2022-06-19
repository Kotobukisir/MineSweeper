package Control;

import Util.Util;
import Display.*;

public class Mouse {
    static int L_x;
    static int L_Y;

    public static void  logic()//接收判断鼠标
    {
        L_Y=0;
        L_x=0;
        if(Util.MOUSE_X> Util.LEI&& Util.MOUSE_Y>3* Util.LEI)//鼠标位置
        {
            L_x=(Util.MOUSE_X- Util.LEI)/ Util.LENGTH+1;
            L_Y=(Util.MOUSE_Y- Util.LEI*3)/ Util.LENGTH+1;
        }

        if(L_x>=1 && L_x<= Util.U_W && L_Y>=1 && L_Y<= Util.U_H)
        {
            if (Util.LEFT) //翻
            {
                if(Util.TOP[L_x][L_Y]==0)
                {
                    Util.TOP[L_x][L_Y]=-1;
                }
                Surface.kong(L_x,L_Y);
                Util.LEFT = false;
            }
            if (Util.RIGHT)//插旗拔旗
            {
                if(Util.TOP[L_x][L_Y]==0)
                {
                    Util.TOP[L_x][L_Y]=1;
                    Util.qi++;
                }
                else if(Util.TOP[L_x][L_Y]==1)
                {
                    Util.TOP[L_x][L_Y]=0;
                    Util.qi--;
                }
                Util.RIGHT = false;
            }
        }
        VoD.fail();
        VoD.win();

    }
}
