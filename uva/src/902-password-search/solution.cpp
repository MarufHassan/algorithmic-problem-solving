#include <iostream>
#include <string>
#include <map>
using namespace std;

int main()
{
    int n;
    string s;
    map<string, int> strmap;
    map<string, int>::iterator itbegin;
    map<string, int>::iterator itend;

    int max;

    while(cin >> n) {
        cin >> s;

        strmap.clear();
        for(int i = 0; i <= s.size() - n; i++) {
            strmap[s.substr(i, n)]++;
        }

        itbegin = strmap.begin();
        itend = strmap.end();
        max = 0;

        while(itbegin != itend) {
            if(itbegin-> second > max) {
                s = itbegin->first;
                max = itbegin->second;
            }
            itbegin++;
        }
        cout << s << endl;

    }

    return 0;
}
