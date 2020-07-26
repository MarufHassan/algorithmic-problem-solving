# Tell me the frequencies!

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
    char str[1002];
    int count[200];
    int a[200];
    int min, blank = 0;

    while(gets(str)) {
        if(blank != 0)
            printf("\n");

        blank = 1;
        for(int i = 32; i < 128; i++) {
            count[i] = 0;
            a[i] = i;
        }

        for(int i = 0; str[i]; i++) {
            if(str[i] >= 32 && str[i] <= 127)
                count[str[i]]++;
        }

        for(int i = 32; i < 128; i++) {
            min = i;
            for(int j = i; j < 128; j++) {
                if(count[j] < count[min] || (count[j] == count[min] && a[j] > a[min]))
                    min = j;
            }
            swapargs(count[i], count[min]);
            swapargs(a[i], a[min]);
        }

        for(int i = 32; i < 128; i++) {
            if(count[i] != 0) {
                printf("%d %d\n", a[i], count[i]);
            }
        }
    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**