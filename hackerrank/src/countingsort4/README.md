# [The Full Counting Sort][title]

## Problem Description

In this challenge, you will use counting sort to sort a list while keeping the order of the strings preserved. Detail description can be found [here][title]. 

**Example 1:**

```
    Input: 
        20
        0 ab
        6 cd
        0 ef
        6 gh
        4 ij
        0 ab
        6 cd
        0 ef
        6 gh
        0 ij
        4 that
        3 be
        0 to
        1 be
        5 question
        1 or
        2 not
        4 is
        2 to
        4 the
    Output:
        - - - - - to be or not to be - that is the question - - - -
```

## Solution

```java
public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);

    int n = Integer.parseInt(bufferedReader.readLine().trim());
    String[] t = new String[2];
    StringBuilder[] string = new StringBuilder[100];

    for (int i = 0; i < n / 2; i++) {
        t = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int key = Integer.parseInt(t[0]);
        if (string[key] == null)
            string[key] = new StringBuilder();
        string[key] = string[key].append("- ");
    }

    for (int i = n / 2; i < n; i++) {
        t = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int key = Integer.parseInt(t[0]);
        if (string[key] == null)
            string[key] = new StringBuilder();
        string[key] = string[key].append(t[1]).append(" ");
    }

    for (int i = 0; i < string.length; i++) {
        if (string[i] != null)
            out.print(string[i]);
    }

    bufferedReader.close();
    out.close();
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://www.hackerrank.com/challenges/countingsort4