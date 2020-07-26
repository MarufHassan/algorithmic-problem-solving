#include <cstdio>
#include <iostream>
#include <cstring>
using namespace std;

unsigned long reverseNum(unsigned long num)
{
    int d = 0;
    unsigned long rev = 0;

    while( num != 0) {
        rev = rev * d + (num % 10);
        num /= 10;
        d = 10;
    }

    return rev;
}

int main()
{
    int t, sc = 1;
    unsigned long num, a, b, sum;

    scanf("%d", &t);

    for(int i = 0; i < t; i++) {
        scanf("%d", &num);
        sum = num + reverseNum(num);

        a = sum;
        b = reverseNum(sum);

        while(a != b) {
            sc++;
            a = a + b;
            b = reverseNum(a);
        }
        printf("%d %u\n", sc, a);
        sc = 1;
    }

    return 0;
}
