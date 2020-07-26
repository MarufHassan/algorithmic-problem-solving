# Numbering roads

## Solution

```c++
#include <cstdio>
#include <cmath>

int main()
{
    int N, R;
    int a, i = 0;

    while(true) {
        scanf("%d %d", &R, &N);
        if(N == 0 && R == 0) break;

        a = ceil((R - N) / (float) N);

        if(a > 26) {
            printf("Case %d: impossible\n", ++i);
        } else {
            printf("Case %d: %d\n",++i, a);
        }

    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**