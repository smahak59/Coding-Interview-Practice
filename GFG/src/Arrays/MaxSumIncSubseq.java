package Arrays;/*
Given an array A of N positive integers. Find the sum of maximum sum increasing subsequence of the given array.

        Input:
        The first line of input contains an integer T denoting the number of test cases. The first line of each test case is N(the size of array). The second line of each test case contains array elements.

        Output:
        For each test case print the required answer in new line.

        Constraints:
        1 ≤ T ≤ 100
        1 ≤ N ≤ 106
        1 ≤ Ai ≤ 106

        Example:
        Input:
        2
        7
        1 101 2 3 100 4 5
        4
        10 5 4 3

        Output:
        106
        10

        Explanation:
        Testcase 1: All the increasing subsequences are : (1,101); (1,2,3,100); (1,2,3,4,5). Out of these (1, 2, 3, 100) has maximum sum,i.e., 106.*/

/*package whatever //do not write package name here */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MaxSumIncSubseq {
    public static void main(String[] args) throws IOException {
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc > 0) {
            int num = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            int[] dp = new int[num];
            for (int i = 0; i < num; i++) {
                dp[i] = arr[i];
            }
            for(int i = 1 ; i < num; i++){
                int max = Integer.MIN_VALUE;
                int j = i-1;
                while(j>=0){
                    if(arr[j]<arr[i] && dp[j]+ arr[i]> dp[i]){
                        dp[i] = dp[j]+arr[i];
                    }
                    j--;

                }

            }
            int maxSum = Integer.MIN_VALUE;
            for(int i =0; i<num;i++){
                if(dp[i]>maxSum){
                    maxSum = dp[i];
                }
            }
            System.out.println(maxSum);

            tc--;

        }
    }
}
