package Arrays;
/**
     * Given an array arr of N integers. Find the contiguous sub-array with maximum sum.
     *
     * Input:
     * The first line of input contains an integer T denoting the number of test cases.
     * The description of T test cases follows. The first line of each test case contains a single integer N denoting the size of array.
     * The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.
     *
     * Output:
     * Print the maximum sum of the contiguous sub-array in a separate line for each test case.
     *
     * Constraints:
     * 1 ≤ T ≤ 100
     * 1 ≤ N ≤ 106
     * -107 ≤ A[i] <= 107
     *
     * Example:
     * Input
     * 2
     * 5
     * 1 2 3 -2 5
     * 4
     * -1 -2 -3 -4
     * Output
     * 9
     * -1
     */

import java.util.*;
import java.lang.*;
import java.io.*;

    public class KadaneAlgo {
        public static void main (String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int tc = Integer.parseInt(br.readLine());
            while(tc>0){
                int num = Integer.parseInt(br.readLine());
                int arr[] = new int[num];
                String strArr[] = br.readLine().split(" ");
                for(int i = 0 ; i < num ; i++){
                    arr[i] = Integer.parseInt(strArr[i]);
                }
                int currSum = 0;
                int maxSoFar = Integer.MIN_VALUE;
                int start = 0, end = 0;
                int s =0,e = 0;
                for(int i = 0 ; i<arr.length; i++){
                    currSum = Math.max(currSum+arr[i], arr[i]);     //DP states to maintain maxsum when ith array element is encountered and included in sum.
                    if(currSum == arr[i]){                         //It can be taken individually or by adding with previous sum
                        s = i;                                   //to maintain start and end index with which currSum is formed
                        e = i;
                    }
                    else{
                        e = i;
                    }
                    maxSoFar = Math.max(maxSoFar,currSum);      //maintain maximum dp state (sum) of all dpstates
                    if (maxSoFar == currSum){
                        start = s;                             //index with which this sum was made
                        end = e;
                    }
                }
                System.out.println(maxSoFar);
                System.out.println(start+ " " + end);
                tc--;
            }

        }
    }

