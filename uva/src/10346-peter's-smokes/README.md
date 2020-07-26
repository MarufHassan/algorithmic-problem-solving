# Peter's smokes

## Solution

```c++
#include <iostream>
#include <cstdio>
using namespace std;

int main() {
    int n, k, count;

    while( scanf("%d %d", &n, &k) == 2) {
        count = n;
        while(n >= k) {
            count += n / k;
            n=(n/k)+(n%k);
        }
        cout << count << endl;
    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**