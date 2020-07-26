# Car

## Solution

```c++
#include <cstdio>
#include <cmath>

int main()
{
    int t, n = 1;
    double a, b, c, x, y;

    do {
        scanf("%d", &t);
        if(t == 0) break;

        scanf("%lf %lf %lf", &a, &b, &c);

        if(t == 1) {
            y = (b - a) / c;
            x = a * c + 0.5 * y * c * c;
        } else if(t == 2) {
            y = (b - a) / c;
            x = a * y + 0.5 * c * y * y;
        } else if(t == 3) {
            x = sqrt(a * a + 2 * b * c);
            y = (x - a) / b;
        } else if(t == 4) {
            x = sqrt(a * a - 2 * b * c);
            y = (a - x) / b;
        }

        printf("Case %d: %.3f %.3f\n", n++, x, y);

    } while(true);

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**