# Word scramble

## Solution

```c++
#include <cstdio>
#include <cstring>

int main()
{
//    freopen("defaultInput.txt","r",stdin);
//    freopen("userOutput.txt","w",stdout);

    char str[500];
    int len;

    while(gets(str)) {
        len = strlen(str);
        for(int i = 0; i <= len; i++) {
            if(i == len || str[i] == ' ') {
                for(int j = i - 1; j >= 0 && str[j] != ' '; j--) {
                    printf("%c", str[j]);
                }
                if(i != len)
                    printf(" ");
            }
        }
        printf("\n");
    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**