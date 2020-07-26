class GfG
{
    long minDist(Long arr[], long n, long x, long y) 
    {
       long minDistance = n, xPtr = 2 * n, yPtr = 2 * n;
       for (int i = 0; i < n; i++) {
           if (arr[i] == x) {
               xPtr = i;
               minDistance = Math.min(minDistance, Math.abs(xPtr - yPtr));
           } else if (arr[i] == y) {
               yPtr = i;
               minDistance = Math.min(minDistance, Math.abs(xPtr - yPtr));
           }
       }
       return minDistance == n ? -1 : minDistance;
    }
}