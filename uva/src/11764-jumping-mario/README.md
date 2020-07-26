# Jumping mario

## Solution

```c++
#include <cstdio>

int main()
{
    int tc;
    int mj, tj, temp;
    int hj, lj;

    scanf("%d", &tc);

    for(int i = 1; i <= tc; i++) {
        scanf("%d", &tj);
        scanf("%d", &mj);

        hj = lj = 0;

        for(int j = 1; j < tj; j++) {
            scanf("%d", &temp);

            if(temp > mj) {
                hj++;
            } else if(temp < mj) {
                lj++;
            }
            mj = temp;
        }
        printf("Case %d: %d %d\n", i, hj, lj);
    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**