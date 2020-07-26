#include <iostream>
#include <set>
#include <string>
#include <cstdlib>
#include <cstdio>
using namespace std;

int main()
{
//    freopen("defaultInput.txt","r",stdin);
//    freopen("userOutput.txt","w",stdout);
    set<string> strset;
    char word;
    string str;

    while(scanf("%c", &word) == 1) {
        if((word >= 'a' && word <= 'z') || (word >= 'A' && word <= 'Z')) {
            str.push_back(tolower(word));
        } else if(str.size() > 0) {
            strset.insert(str);
            str.clear();
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
