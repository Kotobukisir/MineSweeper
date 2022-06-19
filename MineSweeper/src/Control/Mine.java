package Control;
import Util.*;

public class Mine {
    int[] leis = new int[Util.LEI_MAX*2];
    int x,y;
    boolean can = true;
    public void newlei()//雷区生成
    {
        for (int i = 0; i < Util.LEI_MAX * 2; i = i + 2)
        {
            x = (int) (Math.random() * Util.U_H +1);
            y = (int) (Math.random() * Util.U_W +1);

            for(int j=0;j<i;j=j+2)//判断重叠
            {
                if(x==leis[j]&&y==leis[j+1])
                {
                    i=i-2;
                    can = false;
                    break;
                }
            }
            if(can)
            {
                leis[i]=x;
                leis[i+1]=y;
            }
            can = true;
        }

        for(int i = 0; i< Util.LEI_MAX*2; i=i+2)
        {
            Util.MINE[leis[i]][leis[i+1]]=-1;
        }
    }
}
