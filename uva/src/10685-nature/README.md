# Nature

## Solution

```c++
#include <cstdio>
#include <cstring>

char name[5010][35];
int parent[5010];
int size[5010];
int N, max;

int root(int);
void connect(int, int);
bool connected(int, int);
int compare(char *);

int main()
{
//    freopen("defaultInput.txt","r",stdin);
//    freopen("userOutput.txt","w",stdout);
    int R;
    int p, q;
    char name1[35], name2[35];

    while(true) {
        scanf("%d %d", &N, &R);
        if(N == 0 && R == 0) break;

        for(int i = 0; i < N; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for(int i = 0; i < N; i++) {
            scanf("%s", name[i]);
        }
        max = 1;
        for(int i = 0; i < R; i++) {
            scanf("%s %s", name1, name2);
            p = compare(name1);
            q = compare(name2);
            if(!connected(p, q)) {
                connect(p, q);
            }
        }

        printf("%d\n", max);
    }

    return 0;
}

int compare(char *s)
{
    int p = -1;
    for(int i = 0; i < N; i++)
    {
        if(strcmp(s, name[i]) == 0) {
            p = i;
            break;
        }
    }
    return p;
}

int root(int i)
{
    while(i != parent[i]) {
        parent[i] = parent[parent[i]];
        i = parent[i];
    }
    return i;
}

void connect(int p, int q)
{
    int i = root(p);
    int j = root(q);

    if(size[i] < size[j]) {
        parent[i] = j;
        size[j] += size[i];
    } else {
        parent[j] = i;
        size[i] += size[j];
    }
    if(size[i] > max)
        max = size[i];
    if(size[j] > max)
        max = size[j];
}

bool connected(int p, int q)
{
    return root(p) == root(q);
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**