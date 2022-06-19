package Control;

import Util.Util;
import Display.Surface;

public class VoD{
    public static boolean win()//胜利判断
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

    public static boolean fail()//失败判断
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
                    Surface.faillei();
                    return true;
                }
            }
        }
        return false;
    }
}
