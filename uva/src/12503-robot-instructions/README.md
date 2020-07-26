# Robot instructions

## Solution

```c++
#include <cstdio>

int main()
{
    freopen("defaultInput.txt","r",stdin);
    char command[10];
    int p[100];
    int tc, n, c, fp;

    scanf("%d", &tc);

    while(tc--) {
        scanf("%d", &n);
        fp = 0;
        for(int i = 0; i < n; i++) {
            scanf("%s", command);
            if(command[0] == 'L') {
                p[i] = -1;
                fp -= 1;
            } else if(command[0] == 'R') {
                p[i] = 1;
                fp += 1;
            } else {
                scanf("%*s %d", &c);
                p[i] = p[c - 1];
                fp = fp + p[i];
            }
        }
        printf("%d\n", fp);

    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**