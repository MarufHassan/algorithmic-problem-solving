# List of conquests

## Solution

```c++
#include <iostream>
#include <string>
#include <map>
using namespace std;

int main()
{

    map<string, int> strmap;
    string country, name;
    int n;

    cin >> n;

    while(n--) {
        cin >> country;
        strmap[country]++;
        getline(cin, name);
    }

    for(auto rp : strmap) {
        cout << rp.first << " " << rp.second << endl;
    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**