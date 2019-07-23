package Arrays;
/*Given an array A of size N containing 0s, 1s, and 2s; you need to sort the array in ascending order.

        Input:
        The first line contains an integer 'T' denoting the total number of test cases. Then T testcases follow. Each testcases contains two lines of input. The first line denotes the size of the array N. The second lines contains the elements of the array A separated by spaces.

        Output:
        For each testcase, print the sorted array.

        Constraints:
        1 <= T <= 500
        1 <= N <= 106
        0 <= Ai <= 2

        Example:
        Input :
        2
        5
        0 2 1 2 0
        3
        0 1 0

        Output:
        0 0 1 2 2
        0 0 1

        Explanation:
        Testcase 1: After segragating the 0s, 1s and 2s, we have 0 0 1 2 2 which shown in the output.*/

import java.util.*;
import java.lang.*;
import java.io.*;

class DutchFlag {
    public static void main (String[] args) throws IOException {
        //code
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        while(test_case>0){
            int num = Integer.parseInt(br.readLine());
            String strArray[] = br.readLine().split(" ");
            int arr[] = new int[num];
            for(int i = 0 ; i<num;i++){
                arr[i] = Integer.parseInt(strArray[i]);
            }
            //3 way partitioning - Can refer problem (Sort arrays of 0s and 1s - Two partitioning - Dutch Flag problem.)
            int low = 0;       //for storing nect place to put 0s
            int end = num-1;   //for storing next place to put 2s
            int mid = 0;       // traversing array
            int temp = 0;
            while(mid<=end){
                switch(arr[mid]){
                    case 0 :  temp = arr[mid];
                        arr[mid] = arr[low];
                        arr[low] = temp;
                        low++; mid++;
                        break;
                    case 1 :  mid++;
                        break;
                    case 2 :  temp = arr[end];
                        arr[end] = arr[mid];
                        arr[mid] = temp;
                        end--;                 //didn't do mid++ because we are not sure whether the new value at mid
                        break;                // is in it's correct position or not.
                }
            }
            StringBuffer strbf=new StringBuffer();
            for(int i = 0 ; i<num;i++){
                strbf=strbf.append(arr[i]+" ");   //Used StringBuffer to decrease time complexity (TLE was coming)
            }
            System.out.println(strbf);


            test_case--;
        }
    }
}