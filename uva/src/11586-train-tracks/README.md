# Train tracks

## Solution

```c++
#include <cstdio>

int main()
{
    int tc, male, female;
    char c;

    scanf("%d", &tc);
    getchar();

    while(tc--) {
        c = male = female = 0;
        while(c != '\n') {
            scanf("%c", &c);
            if(c == 'M')
                male++;
            else if(c == 'F')
                female++;
        }

        if(male > 1 && male == female) {
            printf("LOOP\n");
        } else {
            printf("NO LOOP\n");
        }
    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**