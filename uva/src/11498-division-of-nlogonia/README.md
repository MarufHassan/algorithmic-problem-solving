# Division of nlogonia

## Solution

```c++
#include <cstdio>

int main()
{
    int t;
    int dp1, dp2;
    int cp1, cp2;

    while(true) {
        scanf("%d", &t);
        if(t == 0) break;

        scanf("%d %d", &dp1, &dp2);

        for (int i = 0; i < t; i++) {
            scanf("%d %d", &cp1, &cp2);
            cp1 = cp1 - dp1;
            cp2 = cp2 - dp2;

            if(cp1 == 0 || cp2 == 0) {
                printf("divisa\n");
            } else if(cp1 > 0 && cp2 > 0) {
                printf("NE\n");
            } else if(cp1 < 0 && cp2 > 0) {
                printf("NO\n");
            } else if(cp1 < 0 && cp2 < 0) {
                printf("SO\n");
            } else if(cp1 > 0 && cp2 < 0) {
                printf("SE\n");
            }

        }
    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**