#include <cstdio>
#include <iostream>
#include <map>
using namespace std;

int main()
{
    map<int, int> intmap;
    char c;
    int count = 0;
    bool hyphen = false;

    while(scanf("%c", &c) == 1) {
        if(c == '#') {
            hyphen = false;
            count = 0;
            for(pair<int, int> it : intmap) {
                cout << it.first << " " << it.second << endl;
            }
            cout << endl;
            intmap.clear();
        } else {
            if(c == '\'') continue;

            if(c == '-') {
                hyphen = true;
                continue;
            }

            if(c == '\n' && hyphen) {
                hyphen = false;
                continue;
            }
            hyphen = false;
            if(c == ' ' || c == '.' || c == ',' || c == '?' || c == '!' || c == '\n') {
                if(count) intmap[count]++;
                count = 0;
            } else  {
                count++;
            }
        }
    }

    return 0;
}
