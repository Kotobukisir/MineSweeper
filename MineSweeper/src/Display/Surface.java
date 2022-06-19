package Display;

import java.awt.*;
import Util.*;
import Control.*;

public class Surface {
    public static void faillei()//失败显示所有雷
    {
        for(int i = 1; i<= Util.U_W; i++)
        {
            for(int j = 0; j<= Util.U_H; j++)
            {
                if(Util.MINE[i][j]==-1&& Util.TOP[i][j]!=1)
                {
                    Util.TOP[i][j]=-1;
                }
                if(Util.MINE[i][j]!=-1&& Util.TOP[i][j]==1)
                {
                    Util.TOP[i][j]=2;
                }
            }
        }
    }

    public void restart()//重写表层
    {
        for(int i = 1; i<= Util.U_W; i++)
        {
            for(int j = 1; j<= Util.U_H; j++)
            {
                Util.TOP[i][j]=0;
            }
        }
    }
    public static void kong(int x, int y)//空白翻开
    {
        if(Util.MINE[x][y]==0)
        {
            for(int i=x-1;i<=x+1;i++)
            {
                for(int j=y-1;j<=y+1;j++)
                {
                    if(Util.TOP[i][j]!=-1)
                    {
                        if(Util.TOP[i][j]==1)
                        {
                            Util.qi--;
                        }
                        Util.TOP[i][j] = -1;
                        if(i>=1&&j>=1&&i<= Util.U_W&&j<= Util.U_H)
                        {
                            kong(i,j);
                        }
                    }
                }
            }
        }
    }
    public void paintSelf(Graphics g)//绘制表层内容
    {
        g.setColor(Color.black);
        Mouse.logic();
        for(int i = 1; i <= Util.U_W; i++)
        {
            for(int j = 1; j<= Util.U_H; j++)
            {
                if(Util.TOP[i][j]==0) {
                    g.drawImage(Util.top,
                            Util.LEI + (i - 1) * Util.LENGTH + 1,
                            Util.LEI * 3 + (j - 1) * Util.LENGTH + 1,
                            Util.LENGTH + 2,
                            Util.LENGTH + 2,
                            null);
                }
                if(Util.TOP[i][j]==1) {
                    g.drawImage(Util.flag,
                            Util.LEI + (i - 1) * Util.LENGTH + 1,
                            Util.LEI * 3 + (j - 1) * Util.LENGTH + 1,
                            Util.LENGTH + 2,
                            Util.LENGTH + 2,
                            null);
                }
                if(Util.TOP[i][j]==2) {
                    g.drawImage(Util.death,
                            Util.LEI + (i - 1) * Util.LENGTH + 1,
                            Util.LEI * 3 + (j - 1) * Util.LENGTH + 1,
                            Util.LENGTH + 2,
                            Util.LENGTH + 2,
                            null);
                }


            }
        }
    }
}
