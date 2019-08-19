package arrays;

import java.util.LinkedList;
import java.util.Queue;

/*
* In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a
  new one with different size but keep its original data.

You're given a matrix represented by a two-dimensional array, and two positive integers r and c
representing the row number and column number of the wanted reshaped matrix, respectively.

The reshaped matrix need to be filled with all the elements of the original matrix in the same
 row-traversing order as they were.

If the 'reshape' operation with given parameters is possible and legal, output the new
reshaped matrix; Otherwise, output the original matrix.

Example 1:
Input:
nums =
[[1,2],
 [3,4]]
r = 1, c = 4
Output:
[[1,2,3,4]]
Explanation:
The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row
 by row by using the previous list.
Example 2:
Input:
nums =
[[1,2],
 [3,4]]
r = 2, c = 4
Output:
[[1,2],
 [3,4]]
Explanation:
There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
Note:
The height and width of the given matrix is in range [1, 100].
The given r and c are all positive.*/

public class ReshapeMatrix {

        public int[][] matrixReshape(int[][] nums, int r, int c) {

            int origRows = nums.length;
            int origCols = nums[0].length;
            if(origRows*origCols!= r*c || nums.length == 0) return nums;

            int newMatrix[][] = new int[r][c];
            int row=0,col =0;
            for(int i = 0; i<r; i++)
            {   newMatrix[i] = new int[c];
                for(int j = 0; j<c;j++){
                    newMatrix[i][j] = nums[row][col];
                    if(col<origCols-1)col++;
                    else if(row<origRows-1) {row++; col=0;}
                }
            }
            return newMatrix;
        }
    public int[][] matrixReshapeUsingQueue(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        if (nums.length == 0 || r * c != nums.length * nums[0].length)
            return nums;
        int count = 0;
        Queue< Integer > queue = new LinkedList< >();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                queue.add(nums[i][j]);
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = queue.remove();
            }
        }
        return res;
    }
        public int[][] matrixReshapeUsingModulus(int[][] nums, int r, int c) {
            int[][] res = new int[r][c];
            if (nums.length == 0 || r * c != nums.length * nums[0].length)
                return nums;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[0].length; j++) {
                    res[count / c][count % c] = nums[i][j];
                    count++;
                }
            }
            return res;
        }

}
