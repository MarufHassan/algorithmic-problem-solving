#include <cstdio>
#define SIZE 2000005
#define MAX 101

int a[SIZE];

void sort(int n)
{
    int count[MAX];
    for (int i = 0; i < MAX; i++) {
        count[i] = 0;
    }

    for (int i = 0; i < n; i++) {
        count[a[i]]++;
    }

    for (int i = 0, k = 0; i < MAX; i++) {
        if (count[i] == 0)  continue;
        for (int j = 0; j < count[i]; j++) {
            a[k++] = i;
        }
    }
}

int main()
{
    int n;

    while(scanf("%d", &n) && n) {
        for (int i = 0; i < n; i++) {
            scanf("%d", &a[i]);
        }

        sort(n);

        for (int i = 0; i < n; i++) {
            printf("%d", a[i]);
            if (i != n - 1)
                printf(" ");
        }
        printf("\n");
    }

    return 0;
}
