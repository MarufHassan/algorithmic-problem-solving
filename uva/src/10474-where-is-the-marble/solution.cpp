#include <cstdio>

template <typename data_t>
void merge(data_t * a, data_t * aux, int low, int mid, int high)
{
    for(int k = low; k <= high; k++)
        aux[k] = a[k];

    int i, j;
    i = low;
    j = mid + 1;

    for(int k = low; k <= high; k++)
    {

        if(i > mid)             a[k] = aux[j++];
        else if(j > high)       a[k] = aux[i++];
        else if(aux[j] < aux[i])a[k] = aux[j++];
        else                    a[k] = aux[i++];

    }
}

template <typename data_t>
void sort(data_t * a, data_t * aux, int low, int high)
{
    if(high <= low)
        return;

    int mid = low + (high - low) / 2;
    sort(a, aux, low, mid);
    sort(a, aux, mid + 1, high);
    merge(a, aux, low, mid, high);
}

template <typename data_t>
void sort(data_t * a, const int n)
{
    data_t aux[n];
    sort(a, aux, 0, n - 1);
}


template <typename data_t>
int binarySearchUpper(data_t * a, data_t key, int length)
{
    int index = -1;
    int mid;
    int lo = 0, hi = length - 1;

    while(lo <= hi)
    {
        mid = lo + (hi - lo) / 2;
        if(key == a[mid]) {
            index = mid;
            lo = mid + 1;
        } else if(key > a[mid]) {
            lo = mid + 1;
        } else if(key < a[mid]) {
            hi = mid - 1;
        }
    }

    return index;
}

template <typename data_t>
int binarySearchLower(data_t * a, data_t key, int length)
{
    int index = -1;
    int mid;
    int lo = 0, hi = length - 1;

    while(lo <= hi)
    {
        mid = lo + (hi - lo) / 2;
        if(key == a[mid]) {
            index = mid;
            hi = mid - 1;
        } else if(key > a[mid]) {
            lo = mid + 1;
        } else if(key < a[mid]) {
            hi = mid - 1;
        }
    }

    return index;
}


int main()
{
//    freopen("defaultInput.txt","r",stdin);
//    freopen("userOutput.txt","w",stdout);

    int a[10000];
    int N, Q, key, pos;
    int t = 1;

    while(true)
    {

        scanf("%d %d", &N, &Q);
        if(N == 0 && Q == 0) break;

        for(int i = 0; i < N; i++)
        {
            scanf("%d", &a[i]);
        }

        sort(a, N);

        printf("CASE# %d:\n", t++);
        for(int i = 0; i < Q; i++)
        {
            scanf("%d", &key);
            pos = binarySearchLower(a, key, N);
            if(pos == -1)
            {
                printf("%d not found\n", key);
            }
            else
            {
                printf("%d found at %d\n", key, pos + 1);
            }
        }

    }

    return 0;
}
