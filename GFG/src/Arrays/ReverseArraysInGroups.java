package Arrays;/*
* Given an array arr[] of positive integers of size N. Reverse every sub-array of K group elements.

Input:
The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. Each test case consist of two lines of input. The first line of each test case consists of an integer N(size of array) and an integer K separated by a space. The second line of each test case contains N space separated integers denoting the array elements.

Output:
For each test case, print the modified array.

Constraints:
1 ≤ T ≤ 200
1 ≤ N, K ≤ 107
1 ≤ A[i] ≤ 1018

Example:
Input
1
5 3
1 2 3 4 5

Output
3 2 1 5 4

Explanation:
Testcase 1: Reversing groups in size 3, first group consists of elements 1, 2, 3. Reversing this group, we have elements in order as 3, 2, 1*/



import java.lang.*;
import java.io.*;
public class ReverseArraysInGroups
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc>0){
            String desc = br.readLine();
            int num = Integer.parseInt(desc.split(" ")[0]);
            int k = Integer.parseInt(desc.split(" ")[1]);
            int arr[] = new int[num];
            String strArr[] = br.readLine().split(" ");
            for(int i = 0 ; i < num ; i++){
                arr[i] = Integer.parseInt(strArr[i]);
            }
            for(int i = 0; i <= num - (num%k); i+=k){
                int st = i;
                int j =0;
                int end = (i+k-1)<num-1?(i+k-1):num-1;       //min of array size and start+k
                while(st<=((i+end)/2) && st<num){
                    int temp = arr[st];
                    arr[st] = arr[end-j];
                    arr[end-j] = temp;
                    st++;
                    j++;
                }
            }
            StringBuffer sb = new StringBuffer();
            for(int i = 0 ; i < num ; i++){
                sb.append(arr[i]+" ");
            }
            System.out.println(sb);


            tc--;
        }
    }
}