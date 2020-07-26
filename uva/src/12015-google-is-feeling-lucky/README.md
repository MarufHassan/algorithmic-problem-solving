# Google is feeling lucky

## Solution

```c++
#include <cstdio>

int main()
{
    char site[15][110];
    int t, p;
    int a[10];

    scanf("%d", &t);

    for(int i = 1; i <= t; i++) {
        p = 0;
        for(int j = 0; j < 10; j++) {
            scanf("%s", site[j]);
            scanf("%d", &a[j]);
            if(a[j] > p)
                p = a[j];
        }
        printf("Case #%d:\n", i);
        for(int j = 0; j < 10; j++) {
            if(p == a[j]) {
                printf("%s\n", site[j]);
            }
        }

    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**