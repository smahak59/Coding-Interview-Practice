/*
Given an array A of N positive numbers. The task is to find the position where equilibrium first occurs in the array. Equilibrium position in an array is a position such that the sum of elements before it is equal to the sum of elements after it.

        Input:
        The first line of input contains an integer T, denoting the number of test cases. Then T test cases follow. First line of each test case contains an integer N denoting the size of the array. Then in the next line are N space separated values of the array A.

        Output:
        For each test case in a new  line print the position at which the elements are at equilibrium if no equilibrium point exists print -1.

        Constraints:
        1 <= T <= 100
        1 <= N <= 106
        1 <= Ai <= 108

        Example:
        Input:
        2
        1
        1
        5
        1 3 5 2 2

        Output:
        1
        3

        Explanation:
        Testcase 1: Since its the only element hence its the only equilibrium point.
        Testcase 2: For second test case equilibrium point is at position 3 as elements below it (1+3) = elements after it (2+2).*/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

public class EquillibriumPoint {
    public static void main (String[] args) throws IOException{
        //code
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        while(test_case>0){
            test_case--;
            int num = Integer.parseInt(br.readLine());
            String strArray[] = br.readLine().split(" ");
            int arr[] = new int[num];
            for(int i = 0 ; i<num;i++){
                arr[i] = Integer.parseInt(strArray[i]);
            }
            int sum = 0 ;
            int leftsum = 0;
            int arr1[]= new int[num];
            for(int i = 0; i<num;i++){
                sum+=arr[i];
            }
            boolean flag = false;

            int arr2[]= new int[num];

            for(int i = 0; i<num;i++){
                sum -= arr[i]; // sum is now right sum for index i   //total right sum till now - the current index value

                if (leftsum == sum){
                    System.out.println(i+1);
                    flag = true;
                }

                leftsum += arr[i];
            }
            if(!flag){
                System.out.println(-1);
            }

        }

        }

}
