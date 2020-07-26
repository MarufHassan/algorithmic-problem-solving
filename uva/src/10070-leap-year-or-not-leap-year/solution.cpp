#include <cstdio>
#include <cstring>

int main()
{
    char a[1000000];
    int len, leap, print = 0, flag;
    int mod4, mod400, mod100, mod15, mod55;

    while(scanf("%s", a) == 1)
    {
        if(print != 0)
            printf("\n");
        print = 1;

        leap = flag = mod4 = mod400 = mod100 = mod15 = mod55 = 0;
        len = strlen(a);

        for(int i = 0; i < len; i++)
        {
            mod4 = (mod4 * 10 + a[i] - '0') % 4;
            mod400 = (mod400 * 10 + a[i] - '0') % 400;
            mod100 = (mod100 * 10 + a[i] - '0') % 100;
            mod15 = (mod15 * 10 + a[i] - '0') % 15;
            mod55 = (mod55 * 10 + a[i] - '0') % 55;
        }

        if ((mod4==0 && mod100!=0) || mod400==0)
        {
            printf("This is leap year.\n");
            leap = 1;
            flag = 1;
        }

        if (mod15==0)
        {
            printf("This is huluculu festival year.\n");
            flag = 1;
        }

        if (leap==1 && mod55==0)
            printf("This is bulukulu festival year.\n");

        if (flag==0)
            printf("This is an ordinary year.\n");
    }

    return 0;
}
