#include <iostream>
#include <cmath>
#include <cstdio>
using namespace std;

int main()
{
    int input;
    int t_m[5], i, temp, t_case;
    double t[5], tax;

    t_m[0] = 180000;
    t_m[1] = 300000;
    t_m[2] = 400000;
    t_m[3] = 300000;
    t_m[4] = 1000000000;

    t[0] = 0;
    t[1] = 0.1;
    t[2] = 0.15;
    t[3] = 0.2;
    t[4] = 0.25;

    cin >> t_case;

    for(int j = 1; j <= t_case; j++) {
        cin >> input;
        tax = 0;
        i = 0;

        while(input > 0) {
            if(input < t_m[i]) {
                temp = input;
            } else {
                temp = t_m[i];
            }
            tax = tax + ceil(temp * t[i]);
            input = input - t_m[i];

            i++;
        }
        if(tax < 2000 && tax > 0) {
            cout << "Case " << j << ": " << 2000 << endl;
        } else {
            cout << "Case " << j << ": " << (int) tax << endl;
        }
    }
    return 0;
}
