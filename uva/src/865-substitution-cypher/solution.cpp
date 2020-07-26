#include <iostream>
#include <map>
#include <cstdio>
#include <cstring>
using namespace std;

int main()
{
//    freopen("defaultInput.txt","r",stdin);
//    freopen("userOutput.txt","w",stdout);
    map<char, char> charmap;
    map<char, char>::iterator it;
    char line[1000], key[100], value[100];
    int tc;
    char c;

    cin >> tc;
    getchar();
    getchar();

    while(tc--) {
        gets(key);
        gets(value);

        charmap.clear();
        for(int i = 0; key[i]; i++) {
            charmap[key[i]] = value[i];
        }

        cout << value << endl << key << endl;

        while(gets(line)) {
            if(!strcmp(line, ""))
                break;
            for(int i = 0; line[i]; i++) {
                it = charmap.find(line[i]);
                if(it != charmap.end())
                    cout << it->second;
                else
                    cout << line[i];
            }
            cout << endl;
        }

        if(tc)
            cout << endl;
    }

    return 0;
}
