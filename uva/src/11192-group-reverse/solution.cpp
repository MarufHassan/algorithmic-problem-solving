#include <cstdio>
#include <cstring>

int main()
{
    int G, a, j, b;
    char str[110];

    while(true) {
        scanf("%d", &G);
        if(G == 0) break;

        scanf("%s", str);
        G = strlen(str) / G;

        a = G - 1;
        j = 2;
        b = 0;
        for(int i = 0; str[i]; i++, a--) {
            if(a < b) {
                a = (G * j) - 1;
                b = b + G;
                j++;
            }
            printf("%c", str[a]);
        }
        printf("\n");

    }

    return 0;
}
