# Primary arithmetic

## Solution

```c++
#include <cstdio>

int main()
{
    freopen("defaultInput.txt","r",stdin);
    freopen("userOutput.txt","w",stdout);
    int n1, n2;
    int d1, d2;
    int carry, count, sum;

    while(true) {
        scanf("%d %d", &n1, &n2);
        if(n1 == 0 && n2 == 0) break;
        carry = count = 0;
        while(n1 != 0 || n2 != 0) {
            d1 = n1 % 10;
            n1 /= 10;
            d2 = n2 % 10;
            n2 /= 10;

            sum = carry + d1 + d2;
            if(sum >= 10) {
                carry = sum / 10;
                count++;
            } else {
                carry = 0;
            }
        }
        if(count == 0) {
            printf("No carry operation.\n");
        } else if(count == 1) {
            printf("%d carry operation.\n", count);
        } else {
            printf("%d carry operations.\n", count);
        }
    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**