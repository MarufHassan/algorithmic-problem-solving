# Rotating sentences

## Solution

```c++
#include <cstdio>
#include <cstring>

int main()
{
    char str[110][110];
    int a = 0, maxLen = 0, len;

    for(int i = 0; i < 110; i++) {
        for(int j = 0; j < 110; j++) {
            str[i][j] = '\0';
        }
    }

    while(gets(str[a])) {
        len = strlen(str[a]);
        if(maxLen < len)
            maxLen = len;
        a++;
    }

    for(int i = 0; i < maxLen; i++) {
        for(int j = a - 1; j >= 0; j--) {
            if(str[j][i] == '\0') {
                printf(" ");
            } else {
                printf("%c", str[j][i]);
            }
        }
        printf("\n");
    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**