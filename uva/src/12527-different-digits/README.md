# Different digits

## Solution

```c++
#include <cstdio>


int main()
{
    int N, M, num, count;
    int digit[10];
    bool flag;

    while(scanf("%d %d", &N, &M) == 2) {

        count = 0;
        for(int i = N; i <= M; i++) {
            flag = true;
            num = i;
            for(int j = 0; j < 10; j++)
                digit[j] = 0;
            while(num != 0) {
                digit[num % 10]++;
                num /= 10;
            }
            for(int j = 0; j < 10; j++) {
                if(digit[j] > 1) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                count++;
            }
        }
        printf("%d\n", count);
    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**