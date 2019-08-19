package arrays;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
* A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.

Now given an M x N matrix, return True if and only if the matrix is Toeplitz.


Example 1:

Input:
matrix = [
  [1,2,3,4],
  [5,1,2,3],
  [9,5,1,2]
]
Output: True
Explanation:
In the above grid, the diagonals are:
"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
In each diagonal all elements are the same, so the answer is True.
Example 2:

Input:
matrix = [
  [1,2],
  [2,2]
]
Output: False
Explanation:
The diagonal "[1, 2]" has different elements.

Note:

matrix will be a 2D array of integers.
matrix will have a number of rows and columns in range [1, 20].
matrix[i][j] will be integers in range [0, 99].

Follow up:

What if the matrix is stored on disk, and the memory is limited such that you can only load at most one row of the matrix into the memory at once?
What if the matrix is so large that you can only load up a partial row into the memory at once?*/

public class ToeplitzMatrix {
    //Solution 1: simple traversal
    /*
    * Complexity Analysis

Time Complexity: O(M*N), as defined in the problem statement.

Space Complexity: O(1).

*/

    public boolean isToeplitzMatrixSimple(int[][] matrix) {
        int height = matrix.length, width = matrix[0].length;
        if (height<=1 || width<=1) return true;
        for (int i=1; i<height; i++){
            for (int j=1; j<width; j++){
                if(matrix[i][j]!=matrix[i-1][j-1])
                    return false;
            }
        }
        return true;
    }
//Solution 2: Load one row each time, store,compare (with the crietria stored in Queue) and update it row by row.

    public boolean isToeplitzMatrixRow(int[][] matrix) {
        if (matrix.length <= 1 || matrix[0].length <= 1) return true;
        Queue<Integer> q = new LinkedList<>();
        for (int i=matrix[0].length-1; i>=0; i--){ //set criteria
            q.add(matrix[0][i]);
        }
        for (int j=1; j<matrix.length; j++){
            q.poll();
            for (int k=matrix[j].length-1; k>0; k--){
                if (matrix[j][k] == q.poll()) // compare
                    q.add(matrix[j][k]);
                else
                    return false;
            }
            q.add(matrix[j][0]);
        }
        return true;
    }
//Solution 3: Load a partial row/column each time, the length of "piece" is defined as variable 'step'

    public int min(int a, int b){
        return((a>b)?b:a);
    }

    public int max(int a, int b){
        return((a<b)?b:a);
    }

    public boolean isToeplitzMatrixPartialRow(int[][] matrix) {
        int width = matrix[0].length;
        int height = matrix.length;
        int step = 3; //This step indicates the maximum length of 'piece' which can be loaded at one time.
        int size = 1;
        int index = width - 1;

        while (index >= 0){
            size = min(index+1, step);
            int[] memory = new int[size];
            for (int i=0; i<size; i++){
                memory[size-i-1] = matrix[0][index-i]; //set memory
            }
            for(int j=1; j<min(height,width); j++){ //check the related pieces of rows
                //set boundary
                int rightbound = min(index+j, width-1);
                int leftbound = max(index-step+1+j, j);
                for(int m=0, n=leftbound; m<size&&n<=rightbound; m++, n++)
                    if(matrix[j][n] != memory[m])
                        return false;
            }
            index -= step;
        }

        index = 0;
        while (index < height){ //for the purpose of completeness, the criteria should include two sides of the matrix
            size = min(height-1-index, step);
            int[] memory = new int[size];
            for (int i=0; i<size; i++){
                memory[size-1-i] = matrix[height-index-1-i][0];
            }
            for (int j=1; j<min(height,width); j++){
                int upperbound = max(height-index-step+j,j+1);
                int lowerbound = min(height-index-1+j,height-1);
                for(int m=0, n=upperbound; m<size&&n<=lowerbound; m++, n++)
                    if(matrix[n][j] != memory[m])
                        return false;
            }
            index+=step;
        }

        return true;
    }
    //Solution 4
    /*
    * Intuition and Algorithm

We ask what feature makes two coordinates (r1, c1) and (r2, c2) belong to the same diagonal?

It turns out two coordinates are on the same diagonal if and only if r1 - c1 == r2 - c2.

This leads to the following idea: remember the value of that diagonal as groups[r-c].
If we see a mismatch, the matrix is not Toeplitz; otherwise it is.

Complexity Analysis

Time Complexity: O(M*N). (Recall in the problem statement that M, NM,N are the number of rows and columns in matrix.)

Space Complexity: O(M+N).*/
    public boolean isToeplitzMatrix(int[][] matrix) {
        Map<Integer, Integer> groups = new HashMap();
        for (int r = 0; r < matrix.length; ++r) {
            for (int c = 0; c < matrix[0].length; ++c) {
                if (!groups.containsKey(r-c))
                    groups.put(r-c, matrix[r][c]);
                else if (groups.get(r-c) != matrix[r][c])
                    return false;
            }
        }
        return true;
    }
}
