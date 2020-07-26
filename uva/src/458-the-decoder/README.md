# The decoder

## Solution

```c++
#include <cstdio>

int main()
{
    char str[500];

    while(gets(str)) {
        for(int i = 0; str[i]; i++) {
            printf("%c", str[i] - 7);
        }
        printf("\n");
    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**