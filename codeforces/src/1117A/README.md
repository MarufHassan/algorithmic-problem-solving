# [Best Subsegment][title]

## Problem Description

Detail instraction can be found [here][title].

## Solution

Compile with `javac Solution.java` and run with `java Solution`.

```java
public static void main (String[] args) {
    FastScanner in = new FastScanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    int n = in.nextInt();
    int[] arr = new int[n];
    int max = -1;
    for (int i = 0; i < n; i++) {
        arr[i] = in.nextInt();
        if (arr[i] > max)
            max = arr[i];
    }
    
    int maxLength = 0;
    int i = 0;
    while (i < n) {
        int j = i + 1;
        if (arr[i] == max) {
            while (j < n && arr[j] == max) {
                j++;
            }
            maxLength = Math.max(maxLength, j - i);
        }
        i = j;
    }
    out.println(maxLength);
    out.close();
}
```


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://codeforces.com/contest/1117/problem/A