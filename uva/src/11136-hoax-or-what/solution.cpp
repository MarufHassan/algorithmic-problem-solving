#include <iostream>
#include <set>

using namespace std;

int main()
{
    multiset<int> intset;
    int d, n, ap;
    long long p;

    while(true) {
        cin >> n;
        if(n == 0) break;
        intset.clear();
        p = 0;
        for(int i = 1; i <= n; i++) {
            cin >> d;
            for(int j = 1; j <= d; j++) {
                cin >> ap;
                intset.insert(ap);
            }

            p = p + (*intset.rbegin() - *intset.begin());

            intset.erase(intset.begin());
            intset.erase(intset.find(*intset.rbegin()));
        }
        cout << p << endl;
    }


    return 0;
}
