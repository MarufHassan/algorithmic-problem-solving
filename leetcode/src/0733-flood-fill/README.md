# [733. Flood Fill][title]

## Problem Description

An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.

Detailed description can be found [here][title].

**Example 1:**

```
Input: 
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]

Explanation: 
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.
```

## Solution

```java
public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    nrow = image.length; ncol = image[0].length;
    original = image[sr][sc];
    color = newColor;
    
    if (original != color)
        fill(image, sr, sc);
    
    return image;
}

private void fill(int[][] image, int row, int col) {
    if (row < 0 || row >= nrow || col < 0 || col >= ncol 
        || image[row][col] != original) return;
    
    image[row][col] = color;
    for (int i = 0; i < 4; i++) {
        fill(image, row + dirY[i], col + dirX[i]);
    }
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/flood-fill/