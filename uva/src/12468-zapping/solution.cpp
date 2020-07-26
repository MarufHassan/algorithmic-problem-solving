#include <cstdio>

int main()
{
    int ch1, ch2, temp;
    int up, down;

    while(true) {
        scanf("%d %d", &ch1, &ch2);
        if(ch1== -1 && ch2 == -1) break;

        if(ch1 > ch2) {
            temp = ch1;
            ch1 = ch2;
            ch2 = temp;
        }

        up = ch2 - ch1;
        down = ch1 + (100 - ch2);

        if(up < down) {
            printf("%d\n", up);
        } else {
            printf("%d\n", down);
        }
    }

    return 0;
}
