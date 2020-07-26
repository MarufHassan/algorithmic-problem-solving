# Sub-prime

## Solution

```c++
#include <cstdio>

int main()
{
    freopen("defaultInput.txt","r",stdin);
    freopen("userOutput.txt","w",stdout);
    int B, N;
    int bank[25];
    int credit, debit, value;
    bool flag;

    while(true) {
        scanf("%d %d", &B, &N);
        if(B == 0 && N == 0) break;

        for(int i = 0; i < B; i++) {
            scanf("%d", &bank[i]);
        }

        for(int i = 0; i < N; i++) {
            scanf("%d %d %d", &debit, &credit, &value);
            bank[debit - 1] -= value;
            bank[credit - 1] += value;
        }

        flag = true;
        for(int i = 0; i < B; i++) {
            if(bank[i] < 0) {
                flag = false;
                break;
            }
        }
        printf("%c\n", flag ? 'S' : 'N');
    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**