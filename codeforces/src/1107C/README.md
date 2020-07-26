# [Brutality][title]

## Problem Description

Detail instraction can be found [here][title].

## Solution

Compile with `javac Solution.java` and run with `java Solution`.

```java
public static void main (String[] args) {
    FastScanner in = new FastScanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    int n = in.nextInt();
    int k = in.nextInt();
    int[] nums = new int[n];

    for (int i = 0; i < n; i++) {
        nums[i] = in.nextInt();
    }
    
    char[] s = in.next().toCharArray();
    PriorityQueue<Integer> pq;

    long count = 0;
    for (int i = 0; i < n; ) {
        int j = i + 1;
        pq = new PriorityQueue<>();
        pq.add(nums[i]);
        while (j < n) {
            if (s[i] != s[j])
                break;
            pq.add(nums[j]);
            if (pq.size() > k)
                pq.poll();
            j++;
        }
        while (!pq.isEmpty()) {
            count += pq.poll();
        }
        i = j;
    }
    out.println(count);

    out.close();
}
```


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://codeforces.com/contest/1107/problem/C