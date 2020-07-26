#include <bits/stdc++.h>
#define SIZE 30

bool inverse(double a[SIZE][SIZE], double inv[SIZE][SIZE], int n)
{
    for (int i = 0; i < n; i++) {
        if (a[i][i] == 0)   return false;
        double t = a[i][i];
        for (int j = 0; j < n; j++) {
            a[i][j] = a[i][j] / t;
            inv[i][j] = inv[i][j] * 1.0 / t;
        }

        for (int j = 0; j < n; j++) {
            if (i == j)     continue;
            t = a[j][i];
            for (int k = 0; k < n; k++) {
                a[j][k] = a[j][k] + (-1 * a[i][k] * t);
                inv[j][k] =  inv[j][k] + (-1.0 * inv[i][k] * t);
            }
        }
    }
    return true;
}

int main()
{
//    freopen("input.txt", "r", stdin);
//    freopen("output.txt", "w", stdout);
    double a[SIZE][SIZE];
    double inv[SIZE][SIZE];
    int n;

    while (true) {
        scanf("%d", &n);
        if (n == 0)  break;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                scanf("%lf", &a[i][j]);
                if (i == j) inv[i][j] = 1;
                else        inv[i][j] = 0;
            }
        }

        if (!inverse(a, inv, n)) {
            printf("Not possible\n\n");
            continue;
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                printf("%f", inv[row][col]);
                if (col != n - 1)
                    printf(" ");
            }
            printf("\n");
        }
        printf("\n");
    }

    return 0;
}
