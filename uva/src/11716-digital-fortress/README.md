# Digital fortress

## Solution

```c++
#include <cstdio>
#include <cstring>
#include <cmath>
using namespace std;

bool checkInt(float num)
{
    int i = (int) num;
    i++;
    return (i - num == 1);
}

int main()
{
    char input[10000];
    int t, len, c;
    float n;

    scanf("%d", &t);
    getchar();

    for(int i = 1; i <= t; i++)
    {
        gets(input);
        len = strlen(input);
        n = sqrt(len);

        if(checkInt(n))
        {
            for(int j = 0; j < n; j++) {
                for(int k = j; k < len; k += n) {
                    printf("%c", input[k]);
                }
            }
            printf("\n");
        }
        else
        {
            printf("INVALID\n");
        }
    }


    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**