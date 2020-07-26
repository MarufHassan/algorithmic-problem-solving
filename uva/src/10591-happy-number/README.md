# Happy number

## Solution

```c++
#include <iostream>
#include <cstdio>
using namespace std;

int get_digit_squared_sum(int n) {
    int sum = 0;

    while(n != 0) {
        sum = sum + ((n % 10) * (n % 10));
        n = n / 10;
    }
    return sum;
}

int main()
{
    int testCase, num, a;


    while(scanf("%d", &testCase)==1) {

        for(int i = 1; i <= testCase; i++) {

       cin >> num;
       a = num;
       while(1) {
            if(get_digit_squared_sum(a) == 1) {
                printf("Case #%d: %d is a Happy number.\n", i, num);
                break;
            } else if(get_digit_squared_sum(a) == 4 || get_digit_squared_sum(a) == 0) {
                printf("Case #%d: %d is an Unhappy number.\n", i, num);
                break;
            } else {
                a = get_digit_squared_sum(a);
            }
       }

    }

    }
    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**