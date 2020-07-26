#include <cstdio>

int main()
{
    int N, K, P, tc;

    scanf("%d", &tc);
    for(int i = 1; i <= tc; i++) {

        scanf("%d %d %d", &N, &K, &P);

        printf("Case %d: %d\n", i, (K - 1 + P) % N + 1);
    }

    return 0;
}
