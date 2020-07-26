# Sms typing

## Solution

```c++
#include <cstdio>
#include <cstring>
using namespace std;

int main()
{
    char c[100];
    int n = 0, t, len, i, j;

    scanf("%d", &t);
    getchar();

    for(i = 1; i <= t; i++)
    {
        gets(c);

        len = strlen(c);
        n = 0;

        for(j = 0; j < len; j++)
        {
            if(c[j] == 'a' || c[j] == 'd' || c[j] == 'g' || c[j] == 'j' || c[j] == 'm' || c[j] == 'p' || c[j] == 't' || c[j] == 'w' || c[j] == ' ')
                n += 1;
            else if(c[j] == 'b' || c[j] == 'e' || c[j] == 'h' || c[j] == 'k' || c[j] == 'n' || c[j] == 'q' || c[j] == 'u' || c[j] == 'x')
                n += 2;
            else if(c[j] == 'c' || c[j] == 'f' || c[j] == 'i' || c[j] == 'l' || c[j] == 'o' || c[j] == 'r' || c[j] == 'v' || c[j] == 'y')
                n += 3;
            else
                n += 4;
        }
        printf("Case #%d: %d\n", i, n);
    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**