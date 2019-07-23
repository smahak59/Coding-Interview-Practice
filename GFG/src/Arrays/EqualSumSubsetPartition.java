package Arrays;
/*
* Given a set of numbers, check whether it can be partitioned into two subsets such that the sum
* of elements in both subsets is same or not.

Input:
The first line contains an integer 'T' denoting the total number of test cases. Each test case
constitutes of two lines. First line contains 'N', representing the number of elements in the
set and the second line contains the elements of the set.

Output:
Print YES if the given set can be partioned into two subsets such that the sum of elements
in both subsets is equal, else print NO.

Constraints:
1 <= T <= 100
1 <= N <= 100
0 <= arr[i] <= 1000

Example:
Input:
2
4
1 5 11 5
3
1 3 5

Output:
YES
NO
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class EqualSumSubsetPartition
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc>0){
            int num = Integer.parseInt(br.readLine());
            int arr[] = new int[num];
            String strArr[] = br.readLine().split(" ");
            int sum = 0;
            for(int i = 0 ; i < num ; i++){
                arr[i] = Integer.parseInt(strArr[i]);
                sum+=arr[i];
            }
            int s = sum/2;
            if(2*s != sum){
                System.out.println("NO");
                tc--;
                continue;
            }
            else{
                if(subSetSum(arr,arr.length,s)){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }

            }
            tc--;


        }
    }
    public static boolean subSetSum(int set[], int n, int sum){
        // The value of subset[i][j] will be true if there is a
        // subset of set[0..j-1] with sum equal to i
        boolean subset[][] =
                new boolean[n+1][sum+1];

        // If sum is 0, then answer is true
        for (int i = 0; i <= n; i++)
            subset[i][0] = true;

        // If sum is not 0 and set is empty, then answer is false
        for (int i = 1; i <= sum; i++)
            subset[0][i] = false;

        // Fill the subset table in botton up manner
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= sum; j++)
            {
                if(j<set[i-1])
                    subset[i][j] = subset[i-1][j];
                if (j >= set[i-1])
                    subset[i][j] = subset[i-1][j] ||
                            subset[i - 1][j-set[i-1]];
            }
        }


        return subset[n][sum];
    }
}
