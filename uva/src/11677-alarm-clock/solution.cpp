#include <iostream>
#include <cstdio>
using namespace std;

int getMinute(int h, int m) {
    return h*60+m;
}

int main()
{
    int h1, m1, h2, m2;

    while(cin >> h1 >> m1 >> h2 >> m2) {
        if(h1 == 0 && m1 == 0 && h2 == 0 && m2 == 0)
            break;
        m1 = getMinute(h1, m1);
        m2 = getMinute(h2, m2);

        if(m1 <= m2)
            cout << (m2 - m1) << endl;
        else
            cout << (1440 - m1 + m2) << endl;
    }

    return 0;
}
