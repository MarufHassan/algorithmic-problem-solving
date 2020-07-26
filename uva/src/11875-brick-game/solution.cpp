#include <cstdio>

int main()
{
    int age, tc, n, m;

    scanf("%d", &tc);

    for(int i = 1; i <= tc; i++) {
        scanf("%d", &n);

        m = n / 2 + 1;

        for(int j = 1; j <= n; j++) {
            scanf("%d", &age);
            if(j == m)
                printf("Case %d: %d\n", i, age);
        }
    }

    return 0;
}
