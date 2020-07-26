#include <iostream>
#include <cstdio>
using namespace std;

int main()
{
    int a[20];
    int t, i = 0;
    long long maxP, product;

    while(scanf("%d", &t) == 1) {
        maxP = 0;
        product = 1;
        for(int i = 0; i < t; i++) {
            scanf("%d", &a[i]);
        }
        for(int i = 0; i < t; i++) {
            for(int j = i; j < t; j++) {
                product = product * a[j];
                if(product > maxP)
                    maxP = product;
            }
            product = 1;
        }
        if(maxP > 0) {
            printf("Case #%d: The maximum product is %lld.\n\n", ++i, maxP);
        }
        else {
            printf("Case #%d: The maximum product is 0.\n\n", ++i);
        }
    }



    return 0;
}
