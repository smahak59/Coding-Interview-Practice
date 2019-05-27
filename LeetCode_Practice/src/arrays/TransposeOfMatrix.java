package arrays;
/*
* 867. Transpose Matrix

Given a matrix A, return the transpose of A.

The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.



Example 1:

Input: [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]
Example 2:

Input: [[1,2,3],[4,5,6]]
Output: [[1,4],[2,5],[3,6]]


Note:

1 <= A.length <= 1000
1 <= A[0].length <= 1000
*/



public class TransposeOfMatrix {

        public int[][] transpose(int[][] A) {
            if(A[0].length!=A.length){
                int B[][] = new int [A[0].length][A.length];
                for(int i = 0; i<A[0].length; i++){
                    B[i] = new int[A.length];
                    for(int j = 0; j < A.length;j++){
                        B[i][j] = A[j][i];
                    }
                }
                return B;
            }
            else{   //Special Case Rows = columns
                for (int i = 0; i <A.length  ; i++) {
                    for (int j = i; j < A[0].length ; j++) {
                        if (i!=j){
                            int temp = A[i][j];
                            A[i][j]= A[j][i];
                            A[j][i] = temp;
                        }
                    }

                }
                return A;
            }
        }

}
