# Above average

## Solution

```c++
#include <cstdio>

int main()
{
    int tc, n;
    int g[1000], sum, count;
    float avg;

    scanf("%d", &tc);

    while(tc--) {

        scanf("%d", &n);
        sum = count = 0;
        for(int i = 0; i < n; i++) {
            scanf("%d", &g[i]);
            sum += g[i];
        }
        avg = (float) sum / n;
        for(int i = 0; i < n; i++) {
            if(g[i] > avg) {
                count++;
            }
        }
        printf("%.3f%\n", (float) count / n * 100);
    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**