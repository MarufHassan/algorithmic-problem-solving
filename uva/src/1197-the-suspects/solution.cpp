#include <cstdio>

int s[30000];
int sz[30000];
int root(int);
void unionQ(int, int);
bool find(int, int);

int main()
{
    freopen("defaultInput.txt","r",stdin);
    int n, m, k;
    int p, q;

    while(true) {
        scanf("%d %d", &n, &m);
        if(n == 0 && m == 0) break;

        for(int i = 0; i < n; i++) {
            s[i] = i;
            sz[i] = 1;
        }

        for(int i = 1; i <= m; i++) {
            scanf("%d", &k);
            for(int j = 0; j < k; j++) {
                if(j == 0) {
                    scanf("%d", &p);
                    continue;
                }
                scanf("%d", &q);
                if(!find(p, q)) {
                    unionQ(p, q);
                }
                p = q;
            }

        }
        printf("%d\n", sz[root(0)]);

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
