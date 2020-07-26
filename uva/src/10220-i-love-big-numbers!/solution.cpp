#include <cstdio>
#define MAX 10000

int multiply(char * res, int x, int size)
{
    int carry = 0;
    int product;

    for(int i = 0; i < size; i++) {
        product = (res[i] - '0') * x + carry;
        res[i] = '0' + product % 10;
        carry = product / 10;
    }

    while(carry) {
        res[size++] = '0' + carry % 10;
        carry /= 10;
    }

    return size;
}

int factorial(int n)
{
    char res[MAX];
    int size = 0;
    int sum = 0;

    res[size++] = '1';

    for(int i = 2; i <= n; i++) {
        size = multiply(res, i, size);
    }

    for(int i = size - 1; i >= 0; i--) {
        sum = sum + (res[i] - '0');
    }

    return sum;
}

int main()
{
//    freopen("defaultInput.txt","r",stdin);
//    freopen("userOutput.txt","w",stdout);

    int n;

    while(scanf("%d", &n) == 1) {
        printf("%d\n", factorial(n));
    }

    return 0;
}
