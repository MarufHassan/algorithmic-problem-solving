#include <iostream>
#include <set>
#include <vector>
#include <cstdio>
using namespace std;

int main()
{
//    freopen("defaultInput.txt","r",stdin);
//    freopen("userOutput.txt","w",stdout);

    multiset<int> green;
    multiset<int> blue;

    vector<int> greenv;
    vector<int> bluev;

    int tc, b, sg, sb;
    int n;

    scanf("%d", &tc);

    while(tc--) {

        scanf("%d %d %d", &b, &sg, &sb);

        green.clear();
        blue.clear();

        greenv.clear();
        bluev.clear();

        for(int i = 1; i <= sg; i++) {
            scanf("%d", &n);
            green.insert(n);
        }

        for(int i = 1; i <= sb; i++) {
            scanf("%d", &n);
            blue.insert(n);
        }

        multiset<int>::reverse_iterator git = green.rbegin();
        multiset<int>::reverse_iterator bit = blue.rbegin();

        while(git != green.rend() && bit != blue.rend()) {
            for(int i = 0; i < b; i++) {
                if(green.size() == 0 || blue.size() == 0) break;

                if(*git > *bit) {
                    greenv.push_back(*git - *bit);
                } else if(*git < *bit) {
                    bluev.push_back(*bit - *git);
                }
                green.erase(green.find(*git));
                blue.erase(blue.find(*bit));
            }

            for(int i = 0; i < greenv.size(); i++) {
                green.insert(greenv[i]);
            }
            for(int i = 0; i < bluev.size(); i++)
                blue.insert(bluev[i]);

            greenv.clear();
            bluev.clear();
        }

        if(green.size() == 0 && blue.size() == 0) {
            printf("green and blue died\n");
        } else if(green.size() > 0) {
            printf("green wins\n");
            git = green.rbegin();
            while(git != green.rend()) {
                printf("%d\n", *git);
                git++;
            }
        } else {
            printf("blue wins\n");
            bit = blue.rbegin();
            while(bit != blue.rend()) {
                printf("%d\n", *bit);
                bit++;
            }
        }
        if(tc)
            printf("\n");
    }

    return 0;
}
