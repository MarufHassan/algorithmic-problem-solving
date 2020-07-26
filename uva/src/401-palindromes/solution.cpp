#include <cstdio>
#include <cstring>

int main()
{
//    freopen("defaultInput.txt","r",stdin);
//    freopen("userOutput.txt","w",stdout);


    char str1[] = "A   3  HIL JM O   2TUVWXY5";
    char str2[] = "1SE Z  8 ";

    char input[25], ch;
    bool mirrored, palindrome;
    int len, a = 0;

    while(scanf("%s", input) == 1) {
        len = strlen(input);
        mirrored = palindrome = true;

        if(a != 0) {
            printf("\n");
        }
        a = 1;

        for(int i = 0; i <= len/2; i++) {
            if(input[i] >= 'A' && input[i] <= 'Z') {
                ch = str1[input[i] - 65];
            } else {
                ch = str2[input[i] - 49];
            }

            if(ch != input[len - 1 - i]) {
                mirrored = false;
            }
            if(input[i] != input[len - 1 - i]) {
                palindrome = false;
            }
        }

        if(mirrored && palindrome) {
            printf("%s -- is a mirrored palindrome.\n", input);
        } else if(mirrored && !palindrome) {
            printf("%s -- is a mirrored string.\n", input);
        } else if(!mirrored && palindrome) {
            printf("%s -- is a regular palindrome.\n", input);
        } else {
            printf("%s -- is not a palindrome.\n", input);
        }

    }

    return 0;
}
