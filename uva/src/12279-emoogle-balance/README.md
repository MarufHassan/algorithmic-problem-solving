# Emoogle balance

## Solution

```c++
#include <cstdio>

int main()
{
    int t, n, a, b, c = 1;

    while(true) {
        scanf("%d", &t);
        if(t == 0) break;

        a = b = 0;
        for(int i = 1; i <= t; i++) {
            scanf("%d", &n);
            if(n == 0)
                a++;
            else
                b++;
        }
        printf("Case %d: %d\n", c++, b - a);
    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**