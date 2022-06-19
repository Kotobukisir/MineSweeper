package Display;

import java.awt.*;
import Util.*;
import Calculation.*;

public class Lnnerlayer {

    int L_x;
    int L_Y;

    void  logic()//接收判断鼠标
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
                kong(L_x,L_Y);
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
        fail();
        win();

    }

    boolean win()//胜利判断
    {
        int count=0;
        for(int i = 1; i<= Util.U_W; i++)
        {
            for (int j = 1; j<= Util.U_H; j++)
            {
                if(Util.TOP[i][j]!=-1)
                {
                    count++;
                }
            }
        }
        if(count== Util.LEI_MAX)
        {
            Util.state=1;
            for (int i = 1; i <= Util.U_W; i++)
            {
                for (int j = 1; j <= Util.U_H; j++)
                {
                    if(Util.TOP[i][j]==0)
                    {
                        Util.TOP[i][j]=1;
                    }
                }
            }
            return true;
        }
        return false;
    }

    boolean fail()//失败判断
    {
        if(Util.qi== Util.LEI_MAX)
        {
            for(int i = 1; i<= Util.U_W; i++)
            {
                for (int j = 1; j <= Util.U_H; j++)
                {
                    if(Util.TOP[i][j]==0)
                    {
                        Util.TOP[i][j]=-1;
                    }
                }
            }
        }
        for(int i = 1; i<= Util.U_W; i++)
        {
            for(int j = 1; j<= Util.U_H; j++)
            {
                if(Util.MINE[i][j]==-1&& Util.TOP[i][j]==-1)
                {
                    Util.state=2;
                    faillei();
                    return true;
                }
            }
        }
        return false;
    }

    void faillei()//失败显示所有雷
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
    void kong(int x,int y)//空白翻开
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
        logic();
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
