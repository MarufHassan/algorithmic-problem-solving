# Sticker collector robot

## Solution

```c++
#include <cstdio>

int a[102][102];
char ins[50002];
char direction;
int posX, posY;
int N, M, S;
int sticker;

void forward()
{
    if( (posX == 0 && direction == 'O') || (posX == M - 1 && direction == 'L')
        || (posY == 0 && direction == 'N') || (posY == N - 1 && direction == 'S') )
            return;

    if(direction == 'N' && a[posY - 1][posX] != 2) {
        posY--;
    } else if(direction == 'S' && a[posY + 1][posX] != 2) {
        posY++;
    } else if(direction == 'L' && a[posY][posX + 1] != 2) {
        posX++;
    } else if(direction == 'O' && a[posY][posX - 1] != 2) {
        posX--;
    }

    if(a[posY][posX] != 2) {
        sticker = sticker + a[posY][posX];
        a[posY][posX] = 0;
    }

}

void right()
{
    if(direction == 'L') {
        direction = 'S';
    } else if(direction == 'O') {
        direction = 'N';
    } else if(direction == 'N') {
        direction = 'L';
    } else if(direction == 'S') {
        direction = 'O';
    }
}

void left()
{
    if(direction == 'L') {
        direction = 'N';
    } else if(direction == 'O') {
        direction = 'S';
    } else if(direction == 'N') {
        direction = 'O';
    } else if(direction == 'S') {
        direction = 'L';
    }
}

int main()
{
//    freopen("defaultInput.txt","r",stdin);

    char c;
    while(true) {
        scanf("%d %d %d", &N, &M, &S);
        if(N == 0 && M == 0 && S == 0) break;
        getchar();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                scanf("%c", &c);
                if(c == '.') {
                    a[i][j] = 0;
                } else if(c == '*') {
                    a[i][j] = 1;
                } else if(c == '#') {
                    a[i][j] = 2;
                } else {
                    a[i][j] = 0;
                    direction = c;
                    posX = j;
                    posY = i;
                }
            }
            getchar();
        }

        gets(ins);

        sticker = 0;
        for(int i = 0; ins[i]; i++) {
            if(ins[i] == 'F') {
                forward();
            } else if(ins[i] == 'D') {
                right();
            } else if(ins[i] == 'E') {
                left();
            }
        }

        printf("%d\n", sticker);
    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**