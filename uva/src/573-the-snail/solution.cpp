#include <cstdio>

int main()
{
    int H, U, D, F, day;
    float IH, DC, HC, HS;

    while(scanf("%d %d %d %d", &H, &U, &D, &F) == 4) {
        if(H == 0) break;

        IH = HC = HS = 0.0;
        day = 0;
        DC = U;

        while((HC >= 0 && HC <= H) && (HS >= 0 && HS <= H)) {
            HC = (IH + DC);
            HS = HC - D;

            DC = DC - (U * (F / 100.0));
            if(DC < 0)
                DC = 0;
            IH = HS;
            day++;
        }

        if(IH < 0) {
            printf("failure on day %d\n", day);
        } else {
            printf("success on day %d\n", day);
        }

    }

    return 0;
}
