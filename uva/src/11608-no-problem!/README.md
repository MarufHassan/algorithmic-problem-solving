# No problem!

## Solution

```c++
#include <iostream>
#include <cstdio>
using namespace std;

int main()
{
    int t, count = 0;
    int a[13], b[13];

    while( cin >> t) {
        if(t < 0)
            break;

        a[0] = t;
        for(int i = 1; i <13; i++) {
            cin >> a[i];
        }

        for(int i = 0; i <12; i++) {
            cin >> b[i];
        }

        cout << "Case " << ++count << ":" << endl;
        for(int i = 0; i < 12; i++) {
            if(a[i] >= b[i]) {
                cout << "No problem! :D" << endl;
                a[i+1] = a[i+1] + (a[i] - b[i]);
            } else {
                cout << "No problem. :(" << endl;
                a[i+1] = a[i+1] + a[i];
            }
        }
    }
    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**