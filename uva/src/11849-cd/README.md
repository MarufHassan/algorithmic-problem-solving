# Cd

## Solution

```c++
#include <cstdio>

int a[1000002];

int binarySearch(int key, int length)
{
	int lo = 0, hi = length - 1;
	while(lo <= hi) {
		int mid = lo + (hi - lo) / 2;
		if(key < a[mid])
			hi = mid - 1;
		else if(key > a[mid])
			lo = mid + 1;
		else
			return mid;
	}
	return -1;
}

int main()
{
    int N, M;
    int n, count;

    while(true) {
        scanf("%d %d", &N, &M);
        if(N == 0 && M == 0) break;

        for(int i = 0; i < N; i++) {
            scanf("%d", &a[i]);
        }

        count = 0;

        for(int i = 0; i < M; i++) {
            scanf("%d", &n);
            if(binarySearch(n, N) >= 0) {
                count++;
            }
        }
        printf("%d\n", count);
    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**