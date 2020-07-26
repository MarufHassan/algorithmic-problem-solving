#include <cstdio>

int main()
{
    int t, s, v, m;

    scanf("%d", &t);

    for(int i = 1; i <= t; i++) {
        scanf("%d", &s);
        m = 0;
        for(int j = 1; j <= s; j++) {
            scanf("%d", &v);
            if(m < v) {
                m = v;
            }
        }
        printf("Case %d: %d\n", i, m);
    }

    return 0;
}
