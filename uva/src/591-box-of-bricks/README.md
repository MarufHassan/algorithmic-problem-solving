# Box of bricks

## Solution

```c++
#include <cstdio>

int main()
{
    int n, t = 0;
    int a[60], sum, minimum;

    while(true) {
        scanf("%d", &n);
        if(n == 0) break;

        sum = 0;
        for(int i = 0; i < n; i++) {
            scanf("%d", &a[i]);
            sum += a[i];
        }

        minimum = 0;
        sum = sum / n;

        for(int i = 0; i < n; i++) {
            if(a[i] > sum) {
                minimum += (a[i] - sum);
            }
        }
        printf("Set #%d\n", ++t);
        printf("The minimum number of moves is %d.\n\n", minimum);
    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**