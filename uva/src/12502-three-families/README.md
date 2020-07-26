# Three families

## Solution

```c++
#include <cstdio>

int main()
{
    int x, y, z, tc;

    scanf("%d", &tc);

    while(tc--) {
        scanf("%d %d %d", &x, &y, &z);

        printf("%d\n", (z * (2 * x - y) / (x + y)));
    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**