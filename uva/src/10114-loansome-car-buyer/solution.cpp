#include <cstdio>

int main()
{
    int tm, dn, dm, m;
    float dpm, lpm, d, bpm, cpm;
    bool flag;

    while(true) {
        scanf("%d %f %f %d", &tm, &dpm, &lpm, &dn);
        if(tm < 0) break;

        bpm = dpm + lpm;
        cpm = dpm + lpm;
        flag = true;
        m = 0;
        for(int i = 0; ; i++, m++) {
            if(flag) {
                scanf("%d", &dm);
                flag = false;
            }
            if(dm == i) {
                scanf("%f", &d);
                flag = true;
            }
            bpm = bpm - dpm;
            cpm = cpm - cpm * (d * 100);

            if(bpm < cpm) break;
        }
        printf("%d\n", m);
    }

    return 0;
}
