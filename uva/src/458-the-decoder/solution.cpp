#include <cstdio>

int main()
{
    char str[500];

    while(gets(str)) {
        for(int i = 0; str[i]; i++) {
            printf("%c", str[i] - 7);
        }
        printf("\n");
    }

    return 0;
}
