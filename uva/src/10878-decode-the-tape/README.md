# Decode the tape

## Solution

```c++
#include <cstdio>
#include <cmath>
#include <cstring>

int binToDecimal(char * p, int len)
{
    int j = 0;
    int dec = 0;

    for(int i = len - 1; i >= 0; i--) {
        dec = dec + ( (p[i] - '0') * pow(2, j++) );
    }

    return dec;
}

int main()
{
    char str[100], index;
    char bin[100];
    int len;

    while(gets(str)) {
        index = 0;
        for(int i = 0; str[i]; i++) {
            if(str[i] == ' ')
                bin[index++] = '0';
            else if(str[i] == 'o')
                bin[index++] = '1';
        }
        bin[index] = '\0';
        len = strlen(bin);

        if(len != 0)
            printf("%c", binToDecimal(bin, len));

    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**