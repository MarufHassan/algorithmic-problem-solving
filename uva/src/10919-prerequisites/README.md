# Prerequisites

## Solution

```c++
#include <cstdio>
#include <algorithm>
using namespace std;

int a[110];
int k;


void merge(int,int,int);
void merge_sort(int low,int high);
int binary_search(int first, int last, int search_key);


int main()
{
//    freopen("defaultInput.txt","r",stdin);
    int m, p, t, course;
    bool flag;
//
//    a[0] = 40;
//    a[1] = 30;
//    a[2] = 20;
//    a[3] = 10;
//    a[4] = 0;
//    merge_sort(0, 4);
//
//    for(int  i = 0; i <=4 ; i++) {
//        printf("%d ", a[i]);
//    }

    while(true) {
        scanf("%d", &k);
        if(k == 0) break;

        scanf("%d", &m);

        for(int i = 0; i < k; i++) {
            scanf("%d", &a[i]);
        }
        merge_sort(0, k - 1);
        flag = true;
        for(int i = 0; i < m; i++) {
            scanf("%d %d", &t, &p);

            for(int j = 0; j < t; j++) {
                scanf("%d", &course);
                if(flag && (binary_search(0, k - 1, course) >= 0)) {
                    p--;
                }
            }
            if(p <= 0 && flag) {
                flag = true;
            } else {
                flag = false;
            }
        }
        if(flag) {
            printf("yes\n");
        } else {
            printf("no\n");
        }
    }

    return 0;
}

void merge_sort(int low,int high)
{
    int mid;
    if(low<high)
    {
        mid=(low+high)/2;
        merge_sort(low,mid);
        merge_sort(mid+1,high);
        merge(low,mid,high);
    }
}
void merge(int low,int mid,int high)
{
    int h,i,j,b[110],k;
    h=low;
    i=low;
    j=mid+1;

    while((h<=mid)&&(j<=high))
    {
        if(a[h]<=a[j])
        {
            b[i]=a[h];
            h++;
        }
        else
        {
            b[i]=a[j];
            j++;
        }
        i++;
    }
    if(h>mid)
    {
        for(k=j; k<=high; k++)
        {
            b[i]=a[k];
            i++;
        }
    }
    else
    {
        for(k=h; k<=mid; k++)
        {
            b[i]=a[k];
            i++;
        }
    }
    for(k=low; k<=high; k++) a[k]=b[k];
}

int binary_search(int first, int last, int search_key)
{
    int index;

    if (first > last)
        index = -1;

    else
    {
        int mid = (first + last)/2;

        if (search_key == a[mid])
            index = mid;
        else

            if (search_key < a[mid])
                index = binary_search(first, mid-1, search_key);
            else
                index = binary_search(mid+1, last, search_key);

    }
    return index;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**