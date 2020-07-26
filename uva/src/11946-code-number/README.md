# Code number

## Solution

```c++
#include <cstdio>
#include <cstring>

int main()
{
//    freopen("defaultInput.txt","r",stdin);
//    freopen("userOutput.txt","w",stdout);
    char number[] = "0123456789";
    char code[] = "OIZEASGTBP";

    char line[80];
    int tc;

    scanf("%d", &tc);
    getchar();

    while(tc--) {

        while(gets(line)) {
            if(!strcmp(line, "")) break;

            for(int i = 0; line[i]; i++) {
                if(line[i] >= '0' && line[i] <= '9') {
                    printf("%c", code[line[i] - 48]);
                } else {
                    printf("%c", line[i]);
                }
            }
            printf("\n");
        }
        if(tc)
            printf("\n");
    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**