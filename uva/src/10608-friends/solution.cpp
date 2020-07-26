#include <cstdio>

int citizens[30000];
int count[30000];
int large;
int N;

void connect(int, int);
int root(int);
bool find(int, int);

int main()
{
    int t;
    int M;
    int A, B;

    scanf("%d", &t);

    while(t--) {
        scanf("%d %d", &N, &M);
        large = 0;
        for(int i = 0; i < N; i++) {
            citizens[i] = i;
            count[i] = 1;
        }

        for(int i = 1; i <= M; i++) {
            scanf("%d %d", &A, &B);
            if(!find(A-1, B-1)) {
                connect(A - 1, B - 1);
            }
        }

        printf("%d\n", large);
    }
    return 0;
}

void connect(int p, int q)
{
    int i = root(p);
    int j = root(q);
    if(count[i] < count[j]) {
        citizens[i] = j;
        count[j] += count[i];
        if(count[j] > large)
            large = count[j];
    } else {
        citizens[j] = i;
        count[i] += count[j];
        if(count[i] > large)
            large = count[i];
    }
}

int root(int i)
{
    while(i != citizens[i]) {
        citizens[i] = citizens[citizens[i]];
        i = citizens[i];
    }
    return i;
}

bool find (int p, int q)
{
    return root(p) == root(q);
}
