# What's the frequency, kenneth

## Solution

```c++
#include <cstdio>

char str[100000];

int main()
{
    int max;
    int u[26], l[26];

    while(gets(str)) {

        for(int i = 0; i < 26; i++) {
            u[i] = 0;
            l[i] = 0;
        }

        max = 0;
        for(int i = 0; str[i]; i++) {
            if(str[i] >= 'A' && str[i] <= 'Z') {
                u[str[i] - 65]++;
                if(u[str[i] - 65] > max)
                    max = u[str[i] - 65];
            }
            if(str[i] >= 'a' && str[i] <= 'z') {
                l[str[i] - 97]++;
                if(l[str[i] - 97] > max)
                    max = l[str[i] - 97];
            }
        }

        for(int i = 0; i < 26; i++) {
            if(u[i] == max) {
                printf("%c", i + 65);
            }
        }

        for(int i = 0; i < 26; i++) {
            if(l[i] == max) {
                printf("%c", i + 97);
            }
        }
        printf(" %d\n", max);

    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**