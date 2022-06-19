package Control;
import Util.*;

public class Num {
    public void newshuzi()
    {
        for (int i = 1; i <= Util.U_W; i++)
        {
            for (int j = 1; j <= Util.U_H; j++)
            {
                if(Util.MINE[i][j]==-1)
                {
                    for(int k=i-1;k<=i+1;k++)
                    {
                        for(int l=j-1;l<=j+1;l++)
                        {
                            if(Util.MINE[k][l]>=0)
                            {
                                Util.MINE[k][l]++;
                            }
                        }
                    }
                }
            }
        }
    }
}
