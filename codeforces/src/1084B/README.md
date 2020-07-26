# [Kvass and the Fair Nut][title]

## Problem Description

Detail instraction can be found [here][title].

## Solution

```java
private static long minLevel(long[] volumes, long capacity) {
    int n = volumes.length;

    long sum = 0;
    int min = 0;
    for (int i = 0; i < n; i++) {
        sum += volumes[i];
        if (volumes[i] < volumes[min])
            min = i;
    }

    if (sum < capacity)
        return -1;

    sum = 0;
    for (int i = 0; i < n; i++) {
        long cut = volumes[i] - volumes[min];
        sum += cut;
    }
    if (sum > capacity)
        return volumes[min];

    long remain = (capacity - sum);
    volumes[min] -=  remain / n;
    remain = remain % n;

    return remain != 0 ? volumes[min] - 1 : volumes[min];
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

```java
import java.util.*;
import java.io.*;

public class Solution {
    private static long minLevel(long[] volumes, long capacity) {
        /* see previous code */
    }

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long capacity = in.nextLong();
        long[] volumes = new long[n];

        for (int i = 0; i < n; i++) {
            volumes[i] = in.nextLong();
        }
        System.out.println(minLevel(volumes, capacity));
        in.close();
	}
}
```


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://codeforces.com/contest/1084/problem/B