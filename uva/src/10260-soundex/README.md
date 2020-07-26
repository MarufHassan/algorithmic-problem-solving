# Soundex

## Solution

```c++
#include <cstdio>
using namespace std;

int main()
{
    char s[22], a;
    int len;

    while(scanf("%s", &s) == 1) {
        a = 0;
        for(int i = 0; s[i]; i++) {
            switch(s[i]) {
            case 'B':
            case 'F':
            case 'P':
            case 'V':
                if(a != 1) {
                    printf("1");
                }
                a = 1;
                break;

            case 'C':
            case 'G':
            case 'J':
            case 'K':
            case 'Q':
            case 'S':
            case 'X':
            case 'Z':
                if(a != 2) {
                    printf("2");
                }
                a = 2;
                break;

            case 'D':
            case 'T':
                if(a != 3) {
                    printf("3");
                }
                a = 3;
                break;

            case 'L':
                if(a != 4) {
                    printf("4");
                }
                a = 4;
                break;

            case 'M':
            case 'N':
                if(a != 5) {
                    printf("5");
                }
                a = 5;
                break;

            case 'R':
                if(a != 6) {
                    printf("6");
                }
                a = 6;
                break;

            default:
                a = 0;
                break;
            }
        }
        printf("\n");
    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**