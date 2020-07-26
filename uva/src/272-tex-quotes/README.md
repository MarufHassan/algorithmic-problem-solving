# Tex quotes

## Solution

```c++
#include <cstdio>

int main()
{
    char c;
    int a = 0;

    while(scanf("%c", &c) == 1) {
        if(c == '\"')
            a++;
        else {
            printf("%c", c);
            continue;
        }

        if(a % 2 == 0) {
            printf("\'\'");
        } else if(a % 2 == 1) {
            printf("``");
        }
    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**