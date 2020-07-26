#include <iostream>
#include <cstdio>
#include <cstring>
using namespace std;

int main()
{

    char s[1024];
    int len, sum;

    while( gets(s)) {
        len = strlen(s);
        sum = 0;
        if(s[0] == '0' && len == 1)
            break;

        for(int i = 0; i < len; i += 2)
            sum += s[i] - '0';
        for(int i = 1; i < len; i+= 2)
            sum -= s[i] - '0';

        if(sum % 11 == 0) {
            cout << s << " is a multiple of 11." << endl;
        } else {
            cout << s << " is not a multiple of 11." << endl;
        }
    }
    return 0;
}
