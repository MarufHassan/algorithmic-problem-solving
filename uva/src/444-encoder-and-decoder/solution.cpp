#include <iostream>
#include <string>
using namespace std;

string encode(const string & s)
{
    string text;
    int n;

    for(int i = s.size() - 1; i >= 0; i--) {
        n = s[i];
        while(n != 0) {
            text.push_back(48 + n % 10);
            n = n / 10;
        }
    }
    return text;
}

string decode(const string & s)
{
    int n = 0;
    string text;

    for(int i = s.size() - 1; i >= 0; i--) {
        n = n * 10 + (s[i] - 48);
        if(n >= 32 && n <= 122) {
            text.push_back(n);
            n = 0;
        }
    }

    return text;
}

int main()
{

    string s;

    while(getline(cin, s)) {
        if(s[0] >= '0' && s[0] <= '9')
            cout << decode(s);
        else
            cout << encode(s);
        cout << endl;
    }

    return 0;
}
