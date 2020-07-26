#include <cstdio>
#include <cstring>

char a[100000][100];
char b[100000][100];
int p[100000];

int main()
{
//    freopen("defaultInput.txt","r",stdin);
//    freopen("userOutput.txt","w",stdout);
    int tc, i, d, n, x;
    char inp[100000];

    scanf("%d\n\n", &tc);

    while(tc--)
    {
        i = n = x = 0;
        gets(inp);
        for(i = 0; inp[i]; i++)
        {
            d = inp[i] - 48;
            if(d >= 0 && d <= 9)
                n = n * 10 + d;
            else
            {
                p[x++] = n;
                n = 0;
            }
        }
        p[x++] = n;

        for(i = 0; i < x; i++)
        {
            scanf("%s", a[i]);
        }

        for(i = 0; i < x; i++)
        {
            strcpy(b[p[i] - 1], a[i]);
        }

        for(i = 0; i < x; i++)
        {
            printf("%s\n", b[i]);
        }
        if(tc)
            printf("\n");
        gets(inp);
        gets(inp);
    }

    return 0;
}
