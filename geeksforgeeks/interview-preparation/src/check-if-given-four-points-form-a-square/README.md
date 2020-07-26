# [Check if given four points form a square][title]

## Problem Description

Given coordinates of four points in a plane, find if the four points form a square or not. Detailed description can be found [here][title]

**Example:**

```
Input
	2
    20 20 20 10 10 20 10 10
    10 10 10 10 20 10 20 30
Output
	1
    0
```

## Solution

```java
private static int distanceSquare(int x1, int y1, int x2, int y2) {
    int dx = x1 - x2;
    int dy = y1 - y2;
    return dx * dx + dy * dy;
}

private static int checkSquare(int[] x, int[] y) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < 4; i++) {
        for (int j = i + 1; j < 4; j++) {
            int d = distanceSquare(x[i], y[i], x[j], y[j]);
            if (map.containsKey(d))
                map.put(d, map.get(d) + 1);
            else
                map.put(d, 1);
        }
    }
    return map.size() == 2 ? 1 : 0;
}
```

**Driver Program**

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    private static int checkSquare(int[] x, int[] y) {
        /* see previous code */
    }
    
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] x = new int[4];
        int[] y = new int[4];
        while (t-- > 0) {
            for (int i = 0; i < 4; i++) {
                x[i] = in.nextInt();
                y[i] = in.nextInt();
            }
            System.out.println(checkSquare(x, y));
        }
        in.close();
    }
}
```

## Test

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://www.geeksforgeeks.org/check-if-given-four-points-form-a-square/