#include <cstdio>
using namespace std;

int main()
{
    char c[8] = { 'C', 'F', 'I', 'L', 'O', 'S', 'V', 'Z' };
    char s[32];

    while(scanf("%s", &s) == 1) {
        for(int i = 0; s[i]; i++) {
            if(s[i] == '1' || s[i] == '0' || s[i] == '-')
                printf("%c", s[i]);
            else {
                for(int j = 0; c[j]; j++) {
                    if(s[i] <= c[j]) {
                        printf("%d", j + 2);
                        break;
                    }
                }
            }
        }
        printf("\n");
    }

    return 0;
}
