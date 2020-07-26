# Abstract names

## Solution

```c++
#include <cstdio>
#include <cstring>
using namespace std;

bool vowelCheck(char c) {
    return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
}

int main()
{
    char str1[22], str2[22];
    int n, l1, l2;
    bool flag;

    scanf("%d", &n);

    for(int i = 0; i < n; i++) {
        flag = true;
        scanf("%s", &str1);
        scanf("%s", &str2);

        l1 = strlen(str1);
        l2 = strlen(str2);

        if(l1 == l2) {
            for(int j = 0; j < l1; j++) {
                if(str1[j] != str2[j]) {
                    if(vowelCheck(str1[j]) && vowelCheck(str2[j])) {
                       flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag)
                printf("Yes\n");
            else
                printf("No\n");
        } else {
            printf("No\n");
        }
    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**