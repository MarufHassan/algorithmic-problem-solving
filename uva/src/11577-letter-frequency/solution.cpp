#include <cstdio>
#include <iostream>
#include <cstring>
using namespace std;

int main()
{
    int t, len, m;
    char s[200];
    char c[27] = "abcdefghijklmnopqrstuvwxyz";
    int n[26] = {0};


    scanf("%d", &t);
    getchar();

    for(int i = 1; i <= t; i++) {
        gets(s);

        for(int j = 0; j < 26; j++) {
            n[j] = 0;
        }
        m = 0;
        len = strlen(s);

        for(int j = 0; j < len; j++) {
            if(s[j] >= 'A' && s[j] <= 'Z') {
                n[s[j]-65]++;
                if(n[s[j]-65] > m) {
                    m = n[s[j]-65];
                }
            } else if(s[j] >= 'a' && s[j] <= 'z') {
                n[s[j]-97]++;
                if(n[s[j]-97] > m) {
                    m = n[s[j]-97];
                }
            }
        }

        for(int j = 0; j < 26; j++) {
            if(n[j] == m) {
                printf("%c", c[j]);
            }
        }
        printf("\n");
    }

    return 0;
}
