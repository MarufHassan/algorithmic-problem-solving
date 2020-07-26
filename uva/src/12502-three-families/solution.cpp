#include <cstdio>

int main()
{
    int x, y, z, tc;

    scanf("%d", &tc);

    while(tc--) {
        scanf("%d %d %d", &x, &y, &z);

        printf("%d\n", (z * (2 * x - y) / (x + y)));
    }

    return 0;
}
