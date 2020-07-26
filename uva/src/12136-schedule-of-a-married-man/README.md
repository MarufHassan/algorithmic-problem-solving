# Schedule of a married man

## Solution

```c++
#include <iostream>
#include <cstdio>
using namespace std;


int main()
{

    int t, m, h, mm1, mm2, wm1, wm2;

    cin >> t;

    for(int i = 1; i <= t; i++)
    {
        scanf("%d:%d", &h, &m);
        wm1 = h * 60 + m;
        scanf("%d:%d", &h, &m);
        wm2 = h * 60 + m;
        scanf("%d:%d", &h, &m);
        mm1 = h * 60 + m;
        scanf("%d:%d", &h, &m);
        mm2 = h * 60 + m;



        if((wm1 <= mm1 && mm1 <= wm2) || (wm1 <= mm2 && mm2 <= wm2) || (mm1 <= wm1 && wm2 <= mm2))
        {
            cout << "Case " << i << ": Mrs Meeting" << endl;
        }
        else
        {
            cout << "Case " << i << ": Hits Meeting" << endl;
        }

    }


    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**