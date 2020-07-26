#include <cstdio>

int main()
{
    int t;
    int n, y1, y2, c;
    bool flag;

    scanf("%d", &t);

    while(t--) {
        flag = true;
        scanf("%d", &n);

        scanf("%d %d", &y1, &y2);
        c = y1 - y2;

        for(int i = 1; i < n; i++) {
            scanf("%d %d", &y1, &y2);
            if(c != y1 - y2) {
                flag = false;
            }
        }
        printf("%s\n", flag ? "yes" : "no");
        if(t)
            printf("\n");
    }

    return 0;
}
