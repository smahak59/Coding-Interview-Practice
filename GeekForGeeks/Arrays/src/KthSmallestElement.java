/*
* Given an array arr and a number K where K is smaller than size of array, the task is to find the K’th smallest element in the given array. It is given that all array elements are distinct.

Expected Time Complexity: O(n)

Input:
The first line of input contains an integer T, denoting the number of testcases. Then T test cases follow. Each test case consists of three lines. First line of each testcase contains an integer N denoting size of the array. Second line contains N space separated integer denoting elements of the array. Third line of the test case contains an integer K.

Output:
Corresponding to each test case, print the desired output in a new line.

Constraints:
1 <= T <= 100
1 <= N <= 105
1 <= arr[i] <= 105
1 <= K <= N

Example:
Input:
2
6
7 10 4 3 20 15
3
5
7 10 4 20 15
4

Output:
7
15

Explanation:
Testcase 1: 3rd smallest element in the given array is 7.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KthSmallestElement {
    public static void main (String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc>0){
            int num = Integer.parseInt(br.readLine());
            int arr[] = new int[num];
            String strArr[] = br.readLine().split(" ");
            for(int i = 0 ; i < num ; i++){
                arr[i] = Integer.parseInt(strArr[i]);
            }
            int k = Integer.parseInt(br.readLine());
            int m = findKthSmallest(arr,0,num-1,k);
            System.out.println(m);
            tc--;
        }
    }
    static int findKthSmallest(int arr[], int l, int r, int k){
        if(k>l && k<=r+1 ){
            int pivot = partition(arr,l,r);
            if(pivot == k-1) return arr[pivot];
            else if(pivot<k-1) return findKthSmallest(arr,pivot+1,r,k);
            else return findKthSmallest(arr,l,pivot-1,k);
        }
        return 0;
    }
    static int partition(int arr[], int l,int r){
        int x = arr[r];
        int j = l-1;
        int temp =0;
        for(int i = l ; i<r; i++){
            if(arr[i]<x){
                j++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        temp = arr[j+1];
        arr[j+1] = arr[r];
        arr[r] = temp;
        return j+1;
    }
}
