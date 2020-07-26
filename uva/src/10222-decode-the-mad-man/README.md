# Decode the mad man

## Solution

```c++
#include <cstdio>
#include <cctype>

int main()
{
    char str[100000];
    char original[] = "asdfghjkl;'\zxcvbnm,./qwertyuiop[]`1234567890-=";
    char replaced[] = "  asdfghjkl;'\zxcvbnm,./qwertyuiop[]`1234567890-=";
    int position;

    while(gets(str)) {

        for(int i = 0; str[i]; i++) {
            if(str[i] == ' ') {
                printf(" ");
                continue;
            }
            for(int j = 0; original[j]; j++) {
                if(tolower(str[i]) == original[j]) {
                    position = j;
                }
            }
            printf("%c", replaced[position]);
        }
        printf("\n");
    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**