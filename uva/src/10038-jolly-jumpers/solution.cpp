#include <cstdio>
#include <cstdlib>

int main()
{
    int n, t1, t2;
    int a[3005];
    bool flag;

    while(scanf("%d", &n) == 1) {
        scanf("%d", &t1);

        for(int i = 0; i <= n; i++)
            a[i] = 0;

        for(int i = 1; i < n; i++) {
            scanf("%d", &t2);
            t1 = abs(t2 - t1);
            a[t1] = t1;
            t1 = t2;
        }
        flag = true;
        for(int i = 1; i < n; i++) {
            if(a[i] != i) {
                printf("Not jolly\n");
                flag = false;
                break;
            }
        }
        if(flag)
            printf("Jolly\n");

    }

    return 0;
}
