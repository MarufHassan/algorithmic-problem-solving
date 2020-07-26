#include <cstdio>
#include <iostream>
#include <map>
#include <set>
using namespace std;

int main()
{
//    freopen("defaultInput.txt","r",stdin);

    char querty[] = "qazwsxedcrfvtgb  yhnujmik,ol.p;/";
    int index[] =  { 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 6, 7, 7, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10 };

    map<char, int> charmap;
    set<int> intset;
    set<string> stringset;
    string s;
    int f, w, temp, max;
    bool flag;

    for(int i = 0; querty[i]; i++) {
        charmap[querty[i]] = index[i];
    }

    while(scanf("%d %d", &f, &w) == 2) {
        intset.clear();
        stringset.clear();

        for(int i = 0; i < f; i++) {
            scanf("%d", &temp);
            intset.insert(temp);
        }
        max = 0;
        for(int i = 0; i < w; i++) {
            cin >> s;
            flag = true;
            for(int j = 0; j < s.size(); j++) {
                if(intset.find(charmap[s[j]]) != intset.end()) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                if(max < s.size()) {
                    max = s.size();
                    stringset.clear();
                    stringset.insert(s);
                } else if(max == s.size()) {
                    stringset.insert(s);
                }
            }
        }

        cout << stringset.size() << endl;
        for(string str : stringset) {
            cout << str << endl;
        }

    }

    return 0;
}
