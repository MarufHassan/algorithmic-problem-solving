# Feynman

## Solution

```c++
#include <cstdio>

int main()
{
    int n, s;

    while(true) {
        scanf("%d", &n);
        if(n == 0) break;

        s = 0;

        while(n > 0) {
            s = s + n * n;
            n--;
        }
        printf("%d\n", s);

    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**