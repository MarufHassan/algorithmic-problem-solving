# Blowing fuses

## Solution

```c++
#include <cstdio>

int main()
{
//    freopen("defaultInput.txt","r",stdin);
//    freopen("userOutput.txt","w",stdout);
    int n, m, c, a = 0;
    int t, maximal, pCom;
    int pc[25];
    int so[25];
    bool flag;

    while(true) {
        scanf("%d %d %d", &n, &m, &c);
        if(n == 0 && m == 0 && c == 0) break;

        for(int i = 0; i < n; i++) {
            scanf("%d", &pc[i]);
            so[i] = 0;
        }
        maximal = pCom = 0;
        flag = false;
        for(int i = 0; i < m; i++) {
            scanf("%d", &t);
            if(so[t - 1] == 0) {
                so[t - 1] = 1;
                pCom = pCom + pc[t - 1];
            } else {
                so[t - 1] = 0;
                pCom = pCom - pc[t - 1];
            }
            if(pCom > maximal && !flag)
                maximal = pCom;
            if(pCom > c)
                flag = true;
        }

//        if( a != 0)
//            printf("\n");
        printf("Sequence %d\n", ++a);
        if(flag) {
            printf("Fuse was blown.\n\n");
        } else {
            printf("Fuse was not blown.\nMaximal power consumption was %d amperes.\n\n", maximal);
        }
    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**