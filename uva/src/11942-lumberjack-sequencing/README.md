# Lumberjack sequencing

## Solution

```c++
#include <cstdio>

int main()
{
    int tc;
    int a[10];
    int asc, desc;

    scanf("%d", &tc);
    printf("Lumberjacks:\n");
    while(tc--) {

        asc = desc = 1;

        for(int i = 0; i < 10; i++) {
            scanf("%d", &a[i]);
        }

        for(int i = 0; i < 9; i++) {
            if(!(a[i] < a[i+1])) {
                asc = 0;
            }
            if(!(a[i] > a[i+1])) {
                desc = 0;
            }
        }
        printf("%s\n", (asc || desc) ? "Ordered" : "Unordered");

    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**