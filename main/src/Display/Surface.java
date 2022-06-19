package Display;

import java.awt.*;
import Util.*;
import Calculation.*;

public class Surface {

    Mine Mine = new Mine();
    Num Num = new Num();
    {
        Mine.newlei();
        Num.newshuzi();
    }
    public void restart()//重置里层
    {
        for(int i = 1; i<= Util.U_W; i++)
        {
            for(int j = 1; j<= Util.U_H; j++)
            {
                Util.MINE[i][j]=0;
            }
        }
        Mine.newlei();
        Num.newshuzi();
    }
    public void paintSelf(Graphics g)//绘制里层
    {
        g.setColor(Color.black);

        for(int i = 0; i <= Util.U_W; i++)//绘制竖线
        {
            g.drawLine(Util.LEI+i* Util.LENGTH,
                    3* Util.LEI,
                    Util.LEI+i* Util.LENGTH,
                    3* Util.LEI+ Util.U_H* Util.LENGTH);
        }

        for(int i = 0; i <= Util.U_H; i++)//绘制横线
        {
            g.drawLine(Util.LEI,
                    3* Util.LEI+i* Util.LENGTH,
                    Util.LEI+ Util.U_W* Util.LENGTH,
                    3* Util.LEI+i* Util.LENGTH);
        }

        for(int i = 1; i <= Util.U_W; i++)//雷和数字的图片
        {
            for(int j = 1; j<= Util.U_H; j++)
            {
                if(Util.MINE[i][j]==-1) {
                    g.drawImage(Util.lei,
                            Util.LEI + (i - 1) * Util.LENGTH + 1,
                            Util.LEI * 3 + (j - 1) * Util.LENGTH + 1,
                            Util.LENGTH + 2,
                            Util.LENGTH + 2,
                            null);
                }

                if(Util.MINE[i][j] >=0) {
                    g.drawImage(Util.images[Util.MINE[i][j]],
                            Util.LEI + (i - 1) * Util.LENGTH + 1,
                            Util.LEI * 3 + (j - 1) * Util.LENGTH + 1,
                            Util.LENGTH -2,
                            Util.LENGTH -2,
                            null);
                }
            }
        }

        Util.Word(g,""+(Util.LEI_MAX- Util.qi), Util.LEI,2* Util.LEI,30,Color.black);
        Util.Word(g,""+(Util.time2- Util.time1)/1000, Util.LEI+ Util.LENGTH*(Util.U_W)-10,2* Util.LEI,30,Color.black);
        //显示剩余雷数和剩余时间
        g.drawImage(Util.start,
                Util.LEI+ Util.LENGTH*(Util.U_W/2)-3,
                Util.LEI-3,
                Util.LENGTH+10,
                Util.LENGTH+10,
                null);

        switch (Util.state)//状态显示
        {
            case 0:
                g.drawImage(Util.zhong,
                        Util.LEI+ Util.LENGTH*(Util.U_W/2)+3,
                        Util.LEI,
                        Util.LENGTH+2,
                        Util.LENGTH+2,
                        null);
                Util.time2=System.currentTimeMillis();
                break;
            case 1:
                g.drawImage(Util.ying,
                        Util.LEI+ Util.LENGTH*(Util.U_W/2)+3,
                        Util.LEI,
                        Util.LENGTH+2,
                        Util.LENGTH+2,
                        null);
                break;
            case 2:
                g.drawImage(Util.shu,
                        Util.LEI+ Util.LENGTH*(Util.U_W/2)+3,
                        Util.LEI,
                        Util.LENGTH+2,
                        Util.LENGTH+2,
                        null);
                break;
        }
    }
}
