#include <cstdio>

void getConnected(int, int);
bool find(int, int);
int root(int);

int a[1000];
int weight[1000];

int main()
{
//    freopen("defaultInput.txt","r",stdin);
//    freopen("userOutput.txt","w",stdout);
    int t, n, p, q, m = 0;
    char ch;
    int s, u;

    scanf("%d", &t);

    while(t--) {

        if(m != 0)
            printf("\n");
        m = 1;

        scanf("%d", &n);
        getchar();

        for(int i = 0; i < n; i++) {
            a[i] = i;
            weight[i] = 1;
        }
        s = u = 0;
        while((ch = getchar()) && (ch != '\n')) {

            scanf("%d %d", &p, &q);

            if(ch == 'c') {
                getConnected(p, q);
            } else if(ch == 'q') {
                if(find(p, q)) {
                    s++;
                } else {
                    u++;
                }
            }
            if(getchar() == EOF)
                break;
        }
        printf("%d,%d\n", s, u);

    }

    return 0;
}

void getConnected(int p, int q)
{
    int i = root(p - 1);
    int j = root(q - 1);

    if(weight[i] < weight[j]) {
        a[i] = j;
        weight[j] += weight[i];
    } else {
        a[j] = i;
        weight[i] += weight[j];
    }
}

bool find(int p, int q)
{
    return root(p - 1) == root(q - 1);
}

int root(int i)
{
    while(i != a[i]){
        a[i] = a[a[i]];
        i = a[i];
    }
    return i;
}
