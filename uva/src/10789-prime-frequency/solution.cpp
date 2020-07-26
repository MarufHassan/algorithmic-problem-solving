#include <cstdio>
#include <cmath>

char str[2100];

bool isPrime(int n)
{
    int l = sqrt(n + 1);
    for(int i = 2; i <= l; i++) {
        if(n % i == 0) {
            return false;
        }
    }
    return true;
}

int main()
{
    char character[63] = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    int digit[62], tc;
    bool flag;

    scanf("%d", &tc);
    getchar();

    for(int k = 1; k <= tc; k++) {
        gets(str);

        for(int i = 0; i < 62; i++) {
            digit[i] = 0;
        }

        for(int i = 0; str[i]; i++) {
            if(str[i] >= 'A' && str[i] <= 'Z') {
                digit[str[i] - 55]++;
            }
            if(str[i] >= 'a' && str[i] <= 'z') {
                digit[str[i] - 61]++;
            }
            if(str[i] >= '0' && str[i] <= '9') {
                digit[str[i] - 48]++;
            }
        }
        flag = true;
        printf("Case %d: ", k);
        for(int i = 0; i < 62; i++) {
            if(digit[i] == 0 || digit[i] == 1)
                continue;
            if(isPrime(digit[i])) {
                printf("%c", character[i]);
                flag = false;
            }
        }
        printf("%s", flag ? "empty\n" : "\n");
    }

    return 0;
}
