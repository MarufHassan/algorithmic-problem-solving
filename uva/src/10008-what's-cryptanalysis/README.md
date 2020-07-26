# What's cryptanalysis

## Solution

```c++
#include <cstdio>

template <class data_t>
int swapargs(data_t &a, data_t &b)
{
    data_t temp;
    temp = a;
    a = b;
    b = temp;
}

int main()
{
//    freopen("defaultInput.txt","r",stdin);
    char character[27] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ", c;
    int count[26], max;
    int n;

    scanf("%d", &n);
    getchar();

    for(int i = 0; i < 26; i++) {
        count[i] = 0;
    }

    while(scanf("%c", &c) == 1) {
        if(c >= 'A' && c <= 'Z')
                count[c - 65]++;
        if(c >= 'a' && c <= 'z')
            count[c - 97]++;
    }

    for(int i = 0; i < 26; i++) {
        max = i;
        for(int j = i; j < 26; j++) {
            if(count[j] > count[max] || (count[j] == count[max] && character[j] < character[max]))
                max = j;
        }
        swapargs(count[i], count[max]);
        swapargs(character[i], character[max]);
    }

    for(int i = 0; i < 26; i++) {
        if(count[i] != 0) {
            printf("%c %d\n", character[i], count[i]);
        }
    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**