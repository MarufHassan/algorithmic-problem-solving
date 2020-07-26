#include <cstdio>

int main()
{
    int n, a = 0;
    bool flag;

    while(true) {
        scanf("%d", &n);
        if(n == 0) break;

        if(a)
            printf("\n");
        a = 1;

        flag = true;
        for(int fghij = 01234; fghij <= 98765 / n; fghij++) {
            int abcde = fghij * n;
            int temp, used = fghij < 10000;
            temp = abcde; while(temp) { used |= (1 << (temp % 10)); temp /=10; }
            temp = fghij; while(temp) { used |= (1 << (temp % 10)); temp /=10; }

            if(used == (1 << 10) - 1) {
                printf("%0.5d / %0.5d = %d\n", abcde, fghij, n);
                flag = false;
            }
        }
        if(flag) {
            printf("There are no solutions for %d.\n", n);
        }
    }

    return 0;
}
