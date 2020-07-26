# Average speed

## Solution

```c++
#include <cstdio>

int main()
{
//    freopen("defaultInput.txt","r",stdin);
    char a[100];
    int h, m, s, speed = 0, newSpeed = 0, n, t1 = 0, t2;
    double d = 0;

    while(gets(a)) {
        n = sscanf(a, "%d:%d:%d %d", &h, &m, &s, &speed);
        t2 = (h * 3600) + (m * 60) + s;
        d = d + ((t2 - t1) / 3600.0) * newSpeed;
        t1 = t2;
        if(n == 3) {
            printf("%02d:%02d:%02d %.2f km\n", h, m, s, d);
        } else {
            newSpeed = speed;
        }
    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**