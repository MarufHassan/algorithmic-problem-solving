# Burger time

## Solution

```c++
#include <cstdio>
#include <cstdlib>

char str[2000000];
int D[2000000];
int R[2000000];

int main()
{
    int L, m, n, min, value;
    bool flag;

    while(true) {
        scanf("%d", &L);
        if(L == 0) break;

        scanf("%s", str);
        m = n = 0;
        flag = true;
        for(int i = 0; str[i]; i++) {
            if(str[i] == 'Z') {
                flag = false;
                break;
            }
            if(str[i] == 'D')
                D[m++] = i + 1;
            else if(str[i] == 'R')
                R[n++] = i + 1;
        }
        min = 2000000;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                value = abs(D[i] - R[j]);
                if( value < min)
                    min = value;
            }
        }
        printf("%d\n", flag ? min : 0);

    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**