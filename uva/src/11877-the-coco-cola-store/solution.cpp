#include <cstdio>

int main()
{
    int b, d;

    while(true) {
        scanf("%d", &b);
        if(b == 0) break;

        d = 0;
        if(b == 2)
            b++;
        while(b >= 3) {
            d = d + b / 3;
            b = b % 3 + b / 3;
            if(b == 2)
                b++;
        }
        printf("%d\n", d);
    }

    return 0;
}
