# Andy's second dictionary

## Solution

```c++
#include <iostream>
#include <set>
#include <string>
#include <cstdlib>
#include <cstdio>
#include <cstring>
using namespace std;

int main()
{

    set<string> strset;
    string str;
    char word[10000];
    bool lastHyphen;
    int len;

    while(gets(word)) {
        len = strlen(word);

        word[len] = '\n';

        lastHyphen = false;
        for(int i = 0; i <= len; i++) {
            if(word[i] == '-' && i == len - 1)
                lastHyphen = true;

            if((word[i] >= 'a' && word[i] <= 'z')
               || (word[i] >= 'A' && word[i] <= 'Z')
               || (word[i] == '-' && i != len - 1)) {

                str.push_back(tolower(word[i]));
            } else if(str.size() > 0 && !lastHyphen)  {
                strset.insert(str);
                str.clear();
            }
        }
    }

    set<string>::iterator itbegin = strset.begin();
    set<string>::iterator itend = strset.end();

    while(itbegin != itend) {
        cout << *itbegin << endl;
        itbegin++;
    }


    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**