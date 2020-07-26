# Summing digits

## Solution

```c++
#include <cstdio>

int main()
{
    char a[15];
    int s, sum;

    while(true) {
        scanf("%s", a);
        if(a[0] == '0') break;

        s = 0;
        for(int i = 0; a[i]; i++) {
            s = s + (a[i] - '0');
        }

        sum = s;
        while(sum / 10 != 0) {
            sum = 0;
            while(s != 0){
                sum = sum + s % 10;
                s = s / 10;
            }
            s = sum;
        }

        printf("%d\n", sum);
    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**