# Mirror clock

## Solution

```c++
#include <cstdio>

int main()
{
    int h1, m1, h2, m2, t, temp;
    int n;

    scanf("%d", &n);

    while(n--) {
        scanf("%d:%d", &h1, &m1);

        t = h1 * 60 + m1;

        if(t <= 360) {
            temp = 360 - t;
            temp += 360;
            h2 = temp / 60 % 12;
            m2 = temp % 60;
        } else if(t > 360) {
            temp = 720 - t;
            temp += 720;
            h2 = temp / 60 % 12;
            m2 = temp % 60;
        }

        printf("%02d:%02d\n", h2 == 12 || h2 == 0 ? 12 : h2, m2);
    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**