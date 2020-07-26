# [1138. Alphabet Board Path][title]

## Problem Description

On an alphabet board, we start at position (0, 0), corresponding to character board[0][0].

Here, board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"], as shown in the diagram below.

We may make the following moves:

'U' moves our position up one row, if the position exists on the board;
'D' moves our position down one row, if the position exists on the board;
'L' moves our position left one column, if the position exists on the board;
'R' moves our position right one column, if the position exists on the board;
'!' adds the character board[r][c] at our current position (r, c) to the answer.
(Here, the only positions that exist on the board are positions with letters on them.)

Return a sequence of moves that makes our answer equal to target in the minimum number of moves.  You may return any path that does so.

**Example 1:**

```
Input: target = "leet"
Output: "DDR!UURRR!!DDD!"
```

**Example 2:**

```
Input: target = "code"
Output: "RR!DDRR!UUL!R!"
```

## Solution

```java
public String alphabetBoardPath(String target) {
    StringBuilder ans = new StringBuilder();
    
    int r = 0, c = 0;
    int row, col;
    for (char ch : target.toCharArray()) {
        row = (ch - 'a') / 5;
        col = (ch - 'a') % 5;
        
        while (c > col) {
            ans.append('L');
            c--;
        }
        while (r > row) {
            ans.append('U');
            r--;
        }
        while (c < col) {
            ans.append('R');
            c++;
        }

        while (r < row) {
            ans.append('D');
            r++;
        }
        ans.append('!');
        r = row; c = col;
    }
    
    return ans.toString();
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/alphabet-board-path/