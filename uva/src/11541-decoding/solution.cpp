#include <cstdio>
#include <cstring>
using namespace std;

int main()
{
    int t, len, a, k, d = 0;
    char input[400];

    scanf("%d", &t);

    for(int i = 0; i < t; i++) {
        scanf("%s", &input);

        len = strlen(input);

        printf("Case %d: ", (i + 1));
        for(int j = 0; j < len; ) {
            k = j + 1;
            while(input[k] >= '0' && input[k] <= '9') {
                a = a * d + (input[k]- 48);
                d = 10;
                k++;
            }

            for(int m = 0; m < a; m++) {
                printf("%c", input[j]);
            }
            j = k;
            a = 0;
            d = 0;
        }
        printf("\n");
    }

    return 0;
}
