# Election

## Solution

```c++
#include <cstdio>
#include <iostream>
#include <map>
#include <string>
using namespace std;

int main()
{
//    freopen("defaultInput.txt","r",stdin);
    map<string, string> candidateM;
    map<string, int> voteM;
    string name, party, voter;
    int tc, vote, c, max;

    scanf("%d", &tc);
    getline(cin, voter);

    while(tc--) {
        candidateM.clear();
        voteM.clear();

        getline(cin,voter);
        scanf("%d", &c);
        getline(cin,voter);

        for(int i = 0; i < c; i++) {
            getline(cin, name);
            getline(cin, party);
            candidateM[name] = party;
        }

        max = 0;
        string temp;

        scanf("%d", &vote);
        getline(cin,voter);

        for(int i = 0; i < vote; i++) {
            getline(cin, name);
            voteM[name]++;
            if(voteM[name] > max) {
                max = voteM[name];
                temp = name;
            }
        }

        int count = 0;
        for(pair<string, int> p : voteM) {
            if (p.second == max)
                count++;
        }

        if(count == 1)
            printf("%s\n", candidateM[temp].c_str());
        else
            printf("tie\n");

        if(tc)
            printf("\n");
    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**