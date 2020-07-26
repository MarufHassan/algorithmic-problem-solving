#include <cstdio>

char str[2000000];

int main()
{
    freopen("defaultInput.txt","r",stdin);
    char c;
    int n;
    int i1, i2, temp, count = 1;

    while(scanf("%s", str) == 1) {
        if(str[0] == '\n') break;

        scanf("%d", &n);
        printf("Case %d:\n", count++);
        for(int i = 1; i <= n; i++) {
            scanf("%d %d", &i1, &i2);

            if(i1 > i2) {
                temp = i1;
                i1 = i2;
                i2 = temp;
            }

            c = str[i1];
            for(int j = i1; j <= i2; j++) {
                if(c != str[j]) {
                    c = 0;
                    break;
                }
            }
            if(c == 0) {
                printf("No\n");
            } else {
                printf("Yes\n");
            }
        }
    }

    return 0;
}
