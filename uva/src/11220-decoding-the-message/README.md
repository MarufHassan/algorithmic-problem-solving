# Decoding the message

## Solution

```c++
#include <cstdio>
#include <iostream>
#include <string>
using namespace std;

int main()
{
//    freopen("defaultInput.txt","r",stdin);

    string s, aux;
    int tc, track;

    scanf("%d", &tc);
    getchar();
    getchar();

    for(int t = 1; t <= tc; t++) {

        if(t != 1)
            cout << endl;

        printf("Case #%d:\n", t);
        while(getline(cin, s)) {
            if(s == "") break;

            track = 0;
            for(int i = 0; i < s.size(); i++) {
                if((s[i] >= 'a' && s[i] <= 'z') || (s[i] >= 'A' && s[i] <= 'Z')) {
                    aux.push_back(s[i]);
                } else if(aux.size() > track) {
                    cout << aux[track++];
                    aux.clear();
                } else {
                    aux.clear();
                }
            }

            if(aux.size() > track) {
                cout << aux[track++];
                aux.clear();
            } else {
                aux.clear();
            }
            cout << endl;

        }
    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**