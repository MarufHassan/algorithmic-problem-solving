# The playboy chimp

## Solution

```c++
#include <cstdio>

template <typename data_t>
int binarySearchUpper(data_t * a, data_t key, int length)
{
    int index = -1;
    int mid;
    int lo = 0, hi = length - 1;

    while(lo <= hi)
    {
        mid = lo + (hi - lo) / 2;
        if(key == a[mid]) {
            index = mid;
            lo = mid + 1;
        } else if(key > a[mid]) {
            lo = mid + 1;
        } else if(key < a[mid]) {
            hi = mid - 1;
        }
    }

    return hi + 1;
}

template <typename data_t>
int binarySearchLower(data_t * a, data_t key, int length)
{
    int index = -1;
    int mid;
    int lo = 0, hi = length - 1;

    while(lo <= hi)
    {
        mid = lo + (hi - lo) / 2;
        if(key == a[mid]) {
            index = mid;
            hi = mid - 1;
        } else if(key > a[mid]) {
            lo = mid + 1;
        } else if(key < a[mid]) {
            hi = mid - 1;
        }
    }

    return lo;
}


int main()
{
    int a[50000];
    int N, Q, pos, n;

    scanf("%d", &N);

    for(int i = 0; i < N; i++) {
        scanf("%d", &a[i]);
    }

    scanf("%d", &Q);

    for(int i = 0; i < Q; i++) {
        scanf("%d", &n);

        pos = binarySearchLower(a, n, N);
        if(pos >= 1) {
            printf("%d ", a[pos - 1]);
        } else {
            printf("X ");
        }

        pos = binarySearchUpper(a, n, N);
        if(pos >= N) {
            printf("X\n");
        } else {
            printf("%d\n", a[pos]);
        }

    }


    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**