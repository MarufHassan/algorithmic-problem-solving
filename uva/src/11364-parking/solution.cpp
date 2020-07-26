#include <cstdio>

int main()
{
    int t, n, a;
    int max, min;

    scanf("%d", &t);

    while(t--) {
        scanf("%d", &n);

        min = 100;
        max = 0;
        for(int i = 1; i <= n; i++) {
            scanf("%d", &a);
            if(min > a)
                min = a;
            if(max < a)
                max = a;
        }
        printf("%d\n", (max - min) * 2);
    }

    return 0;
}
