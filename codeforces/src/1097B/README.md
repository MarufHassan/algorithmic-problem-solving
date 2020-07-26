# [Petr and a Combination Lock][title]

## Problem Description

Detail instraction can be found [here][title].

## Solution

Compile with `javac Solution.java` and run with `java Solution`.

```java
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        for (int i = 0; i < (1 << n); i++) { 
            int sum = 0; 

            // Initially 100 in binary  
            // if n is 3 as  
            // 1<<(3-1) = 100 in binary 
            int num = 1 << (n - 1); 

            // Iterate in the array  
            // and assign signs to 
            // the array elements 
            for (int j = 0; j < n; j++) 
            { 

                // If the j-th bit  
                // from left is set 
                // take '+' sign 
                if ((i & num) > 0) 
                    sum += a[j]; 
                else
                    sum += (-1 * a[j]); 

                // Right shift to check if 
                // jth bit is set or not 
                num = num >> 1; 
            } 

            if (sum % 360 == 0) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");

        in.close();
        out.close();
    }
}
```


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://codeforces.com/contest/1097/problem/B