# Greedy gift givers

## Solution

```c++
#include <cstdio>
#include <cstring>

char tName[15][15];
int tm;

int stringCompare(char *p)
{
    int i;
    for(i = 0; i < tm; i++) {
        if(strcmp(p, tName[i]) == 0)
            break;
    }
    return i;
}

int main()
{
    int m, pm, p;
    int tMoney[15];
    char pName[15];
    int a = 0;

    while(scanf("%d", &tm) == 1) {
        if(a != 0)
            printf("\n");
        a = 1;

        for(int i = 0; i < tm; i++) {
            scanf("%s", tName[i]);
            tMoney[i] = 0;
        }

        for(int i = 0; i < tm; i++) {
            scanf("%s %d %d", pName, &m, &pm);
            p = stringCompare(pName);
            tMoney[p] = tMoney[p] - m;
            if(pm != 0) {
                tMoney[p] = tMoney[p] + (m - (m / pm) * pm);
            } else {
                tMoney[p] = tMoney[p] + m;
            }

            for(int j = 1; j <= pm; j++) {
                scanf("%s", pName);
                p = stringCompare(pName);
                tMoney[p] = tMoney[p] + (m / pm);
            }

        }

        for(int i = 0; i < tm; i++) {
            printf("%s %d\n", tName[i], tMoney[i]);
        }
    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**