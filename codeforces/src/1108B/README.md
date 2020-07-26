# [Divisors of Two Integers][title]

## Problem Description

Detail instraction can be found [here][title].

## Solution

Compile with `javac Solution.java` and run with `java Solution`.

```java
public static void main (String[] args) {
    FastScanner in = new FastScanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    int n = in.nextInt();
    List<Integer> a = new ArrayList<>();

    for (int i = 0; i < n; i++) {            
        a.add(in.nextInt());
    }

    Collections.sort(a);
    int d1 = a.get(n - 1);
    List<Integer> factors = factors(a.get(n - 1));
    for (Integer f : factors) {
        a.remove(f);
    }
    
    int d2 = a.get(a.size() - 1);
    
    out.println(d1 + " " + d2);
    out.close();
}
```
**private helper method**

```java
private static List<Integer> factors(int n) {
    List<Integer> divs = new ArrayList<Integer>();
    for (int i = 1; i * i <= n; i++) {
        if (n % i == 0) {
        divs.add(i);
            if (i * i < n) divs.add(n / i);
        }
    }
    return divs;
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://codeforces.com/contest/1108/problem/B