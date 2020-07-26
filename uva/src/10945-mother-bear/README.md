# Mother bear

## Solution

```c++
#include <cstdio>
#include <cstring>
#include <cctype>

int main()
{
    char str[100000];
    char a[100000];
    int len, j;
    bool flag;

    while(gets(str)) {
        if(strcmp(str, "DONE") == 0) break;

        flag = true;
        j = 0;
        for(int i = 0; str[i]; i++) {
            if((str[i] >= 'A' && str[i] <= 'Z') || (str[i] >='a' && str[i] <= 'z')) {
                a[j++] = str[i];
            }
        }
        a[j] = '\0';
        len = strlen(a);
        for(int i = 0; i < (len / 2 + 1); i++) {
            j = len - 1 - i;
            if(tolower(a[i]) != tolower(a[j])) {
                flag = false;
                break;
            }
        }
        printf("%s\n", flag ? "You won't be eaten!" : "Uh oh..");
    }

    return 0;
}


```


**This is only for discussion and communication. Please don't use this for submission of assignments.**