# Ubiquitous religions

## Solution

```c++
#include <cstdio>

int s[50000];
int sz[50000];
int n, counter;

int root(int);
void unionQ(int, int);
bool find(int, int);

int main()
{
//    freopen("defaultInput.txt","r",stdin);
    int m, p, q, a = 0;

    while(true) {
        scanf("%d %d", &n, &m);
        if(m == 0 && n == 0) break;

        counter = n;

        for(int i = 0; i < n; i++) {
            s[i] = i;
            sz[i] = 1;
        }

        for(int i = 1; i <= m; i++) {
            scanf("%d %d", &p, &q);
            if(!find(p - 1, q - 1)) {
                unionQ(p - 1, q - 1);
            }
        }

        printf("Case %d: %d\n", ++a, counter);
    }

    return 0;
}

void unionQ(int p, int q)
{
    int i = root(p);
    int j = root(q);

    if(sz[i] < sz[j]) {
        s[i] = j;
        sz[j] += sz[i];
    } else {
        s[j] = i;
        sz[i] += sz[j];
    }
    counter--;
}

bool find(int p, int q)
{
    return root(p) == root(q);
}

int root(int i)
{
    while(i != s[i]) {
        s[i] = s[s[i]];
        i = s[i];
    }
    return i;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**