#include <cstdio>

int main()
{
    char num[200];
    int r;

    while(gets(num)) {
        if(num[0] == '0') break;

        r = 0;
        for(int i = 0; num[i]; i++) {
            r = r * 10 +  (num[i] - '0');
            r = r % 17;
        }
        printf("%d\n", r == 0 ? 1 : 0);
    }

    return 0;
}
