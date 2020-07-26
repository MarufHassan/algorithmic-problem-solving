# Just prune the list

## Solution

```c++
#include <iostream>
#include <cstdio>
#include <set>
using namespace std;

int main()
{
    multiset<int> firstSet;
    multiset<int> secondSet;
    int N, M, tc, n;
    int counter;

    scanf("%d", &tc);

    while(tc--) {

        scanf("%d %d", &N, &M);

        firstSet.clear();
        secondSet.clear();

        for(int i = 0; i < N; i++) {
            scanf("%d", &n);
            firstSet.insert(n);
        }

        for(int i = 0; i < M; i++) {
            scanf("%d", &n);
            secondSet.insert(n);
        }

        counter = 0;
        multiset<int>::iterator firstBegin = firstSet.begin();
        multiset<int>::iterator secondBegin = secondSet.begin();

        while(firstBegin != firstSet.end() && secondBegin != secondSet.end()) {
            if(*firstBegin > *secondBegin) {
                counter++;
                secondBegin++;
            } else if(*firstBegin < *secondBegin) {
                counter++;
                firstBegin++;
            } else {
                firstBegin++;
                secondBegin++;
            }
        }

        while(firstBegin != firstSet.end()) {
            counter++;
            firstBegin++;
        }
        while(secondBegin != secondSet.end()) {
            secondBegin++;
            counter++;
        }

        printf("%d\n", counter);

    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**