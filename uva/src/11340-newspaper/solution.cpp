#include <cstdio>
#include <cstring>

int main()
{
//    freopen("defaultInput.txt","r",stdin);
    char a[10010];
    int N, K, M, len;
    char c[110];
    int p[110];
    int price;

    scanf("%d\n", &N);
    while(N--)
    {

        scanf("%d\n", &K);

        for(int i = 0; i < K; i++)
        {
            scanf("%c%d\n", &c[i], &p[i]);
        }

        scanf("%d\n", &M);
        price = 0;
        for(int i = 0; i < M; i++)
        {
            gets(a);
            for(int j = 0; a[j]; j++)
            {
                for(int k = 0; k < K; k++)
                {
                    if(a[j] == c[k])
                    {
                        price = price + p[k];
                        break;
                    }
                }
            }
        }
        printf("%.2f$\n", price / 100.0);
    }

    return 0;
}
