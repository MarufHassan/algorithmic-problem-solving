# Funny encryption method

## Solution

```c++
#include <iostream>
#include <string>
#include <stack>
#include <vector>
#include <cstdio>
using namespace std;

string hexToBin(int n)
{
    stack<string> stck;
    vector<string> strvec = { "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001" };
    string bin;

    while(n != 0) {
        stck.push(strvec[n % 10]);
        n /= 10;
    }

    while(!stck.empty()) {
        bin.append(stck.top());
        stck.pop();
    }
    return bin;
}

string decToBin(int n)
{
    stack<char> stck;
    string bin;

    while(n != 0) {
        stck.push(48 + n % 2);
        n /= 2;
    }

    while(!stck.empty()) {
        bin.push_back(stck.top());
        stck.pop();
    }
    return bin;
}

int main()
{
//    freopen("defaultInput.txt","r",stdin);
//    freopen("userOutput.txt","w",stdout);
    int tc, n;
    string hex, dec;
    int b1, b2;

    cin >> tc;

    while(tc--) {
        cin >> n;

        dec = decToBin(n);
        hex = hexToBin(n);

        b1 = b2 = 0;
        for(int i = 0; i < dec.size(); i++) {
            if(dec[i] == '1')
                b1++;
        }

        for(int i = 0; i < hex.size(); i++) {
            if(hex[i] == '1')
                b2++;
        }
        cout << b1 << " " << b2 << endl;

    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**