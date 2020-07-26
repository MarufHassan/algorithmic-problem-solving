#include <cstdio>

int main()
{
    freopen("defaultInput.txt","r",stdin);
freopen("userOutput.txt","w",stdout);
    char name[100][100];
    char wish[][10] = { "Happy", "birthday", "to", "you", "Happy", "birthday", "to", "you",
                       "Happy", "birthday", "to", "Rujia", "Happy", "birthday", "to", "you" };
    int n, i, a = 16, j = 0;

    scanf("%d", &n);

    for(i = 0; i < n; i++) {
        scanf("%s", name[i]);
    }

    while(a <= n) {
        a *= 2;
    }

    i = 0;
    while(a--) {
        i = i % 16;
        j = j % n;
        printf("%s: %s\n", name[j++], wish[i++]);
    }

    return 0;
}
