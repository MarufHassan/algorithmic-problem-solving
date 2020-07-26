#include <cstdio>
#include <iostream>
#include <string>
#include <map>
using namespace std;

int main()
{
//    freopen("defaultInput.txt","r",stdin);
//    freopen("userOutput.txt","w",stdout);
    string querty = "`1234567890-=qwertyuiop[]\\asdfghjkl;'zxcvbnm,./ ~!@#$%^&*()_+QWERTYUIOP{}|ASDFGHJKL:\"ZXCVBNM<>?";
    string dvorak = "`123qjlmfp/[]456.orsuyb;=\\789aehtdck-0zx,inwvg' ~!@#QJLMFP?{}$%^>ORSUYB:+|&*(AEHTDCK_)ZX<INWVG\"";
    char input[1002];

    map<char, char> charmap;

    for(int i = 0; i < querty.size(); i++) {
        charmap[querty[i]] = dvorak[i];
    }

    while(gets(input)) {

        for(int i = 0; input[i]; i++) {
            if(input[i] == ' ') {
                printf("%c", input[i]);
            } else if(input[i] == '\n') {
                printf("%c", input[i]);
            } else {
                printf("%c", charmap[input[i]]);
            }
        }
        printf("\n");
    }

    return 0;
}
