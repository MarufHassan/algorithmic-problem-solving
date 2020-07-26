#include <cstdio>
#include <iostream>
#include <set>
using namespace std;

int main()
{
//    freopen("defaultInput.txt","r",stdin);
    set<int> intset;
    set<int>::iterator itbegin;
    int n, data;
    bool flag;

    while(true) {
        scanf("%d", &n);
        if(n == 0) break;

        intset.clear();

        for(int i = 0; i < n; i++) {
            scanf("%d", &data);
            intset.insert(data);
        }

        itbegin = intset.begin();
        data = *itbegin;
        itbegin++;
        flag = true;
        while(itbegin != intset.end()) {
            if(*itbegin - data > 200)
                flag = false;
            data = *itbegin;
            itbegin++;
        }

        if(((1422 - *intset.rbegin()) * 2) > 200) {
            flag = false;
        }


        if(flag)
            printf("POSSIBLE\n");
        else {
            printf("IMPOSSIBLE\n");
        }

    }

    return 0;
}
