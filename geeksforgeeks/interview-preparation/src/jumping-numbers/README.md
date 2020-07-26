# [Jumping Numbers][title]

## Problem Description

Given a positive number X. Find all Jumping Numbers smaller than or equal to X. 

Jumping Number: A number is called Jumping Number if all adjacent digits in it differ by only 1. All single digit numbers are considered as Jumping Numbers. For example 7, 8987 and 4343456 are Jumping numbers but 796 and 89098 are not.

Detailed description can be found [here][title]

**Example:**

```
Input
	2
    10
    50
Output
	0 1 2 3 4 5 6 7 8 9 10
    0 1 2 3 4 5 6 7 8 9 10 12 21 23 32 34 43 45
```

## Solution

**Approach 1: Brute Force (TLE)**

```java
private static boolean isJumpingNumber(int n) {
    int d = n % 10;
    n = n / 10;
    while (n != 0) {
        int t = (n % 10);
        if (Math.abs(d - t) != 1)
            return false;
        d = t;
        n /= 10;
    }
    return true;
}

public static void main (String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int t = in.nextInt();
    while (t-- > 0) {
        int n = in.nextInt();
        for (int i = 0; i <= n; i++) {
            if (isJumpingNumber(i))
                out.print(i + " ");
        }
        out.println();
    }
    out.close();
    in.close();
}
```

**Approach 2: Recursive (AC)**

```java
private static void find(int d, int base, int n, int limit, SortedSet<Integer> sets) {
    n = d * base + n;
    if (n > limit)
        return;
    sets.add(n);
    if (d > 0)
        find(d - 1, base * 10, n, limit, sets);
    if (d < 9)
        find(d + 1, base * 10, n, limit, sets);
}

private static Set<Integer> find(int n) {
    SortedSet<Integer> numbers = new TreeSet<>();
    for (int d = 0; d <= 9; d++) {
        if (d > 0)
            find(d - 1, 1, 0, n, numbers);
        if (d < 9)
            find(d + 1, 1, 0, n, numbers);
    }
    return numbers;
}

public static void main (String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int t = in.nextInt();
    while (t-- > 0) {
        int n = in.nextInt();
        for (int i : find(n))
            out.print(i + " ");
        out.println();
    }
    out.close();
    in.close();
}
```

**Approach 3: BFS**

```java
private static void find(long d, long limit, List<Long> numbers) {
    Queue<Long> q = new LinkedList<>();
    q.add(d);
    while (!q.isEmpty()) {
        long pop = q.remove();
        if (pop <= limit) {
            numbers.add(pop);
            long ld = pop % 10;
            if (ld > 0)
                q.add((pop * 10) + (ld - 1));
            if (ld < 9)
                q.add((pop * 10) + (ld + 1));
        }
    }
}

private static List<Long> find(long n) {
    List<Long> numbers = new ArrayList<>();
    numbers.add(0L);
    for (long d = 1; d <= 9 && d <= n; d++) {
        find(d, n, numbers);
    }
    return numbers;
}

public static void main (String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int t = in.nextInt();
    while (t-- > 0) {
        long n = in.nextLong();
        List<Long> result = find(n);
        Collections.sort(result);
        for (long i : result)
            out.print(i + " ");
        out.println();
    }
    out.close();
    in.close();
}
```

## Test

Compile with `javac GFG.java` and run with `java GFG`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://practice.geeksforgeeks.org/problems/jumping-numbers/0/