# [682. Baseball Game][title]

## Problem Description

Detailed description can be found [here][title]

**Example 1:**

```
Input: ["5","2","C","D","+"]
Output: 30
Explanation: 
Round 1: You could get 5 points. The sum is: 5.
Round 2: You could get 2 points. The sum is: 7.
Operation 1: The round 2's data was invalid. The sum is: 5.  
Round 3: You could get 10 points (the round 2's data has been removed). The sum is: 15.
Round 4: You could get 5 + 10 = 15 points. The sum is: 30.
```

**Example 2:**

```
Input: ["5","-2","4","C","D","9","+","+"]
Output: 27
Explanation: 
Round 1: You could get 5 points. The sum is: 5.
Round 2: You could get -2 points. The sum is: 3.
Round 3: You could get 4 points. The sum is: 7.
Operation 1: The round 3's data is invalid. The sum is: 3.  
Round 4: You could get -4 points (the round 3's data has been removed). The sum is: -1.
Round 5: You could get 9 points. The sum is: 8.
Round 6: You could get -4 + 9 = 5 points. The sum is 13.
Round 7: You could get 9 + 5 = 14 points. The sum is 27.
```

## Solution


```java
public int calPoints(String[] ops) {
    Stack<Integer> stack = new Stack<Integer>();
    for (String s : ops) {
        if (s.equals("C")) {
            stack.pop();
        } else if (s.equals("D")) {
            stack.push(2 * stack.peek());
        } else if (s.equals("+")) {
            int top = stack.pop();
            int newTop = top + stack.peek();
            stack.push(top);
            stack.push(newTop);
        } else {
            stack.push(Integer.parseInt(s));
        }
    }
    
    int points = 0;
    for (int p : stack) points += p;
    
    return points;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/baseball-game/