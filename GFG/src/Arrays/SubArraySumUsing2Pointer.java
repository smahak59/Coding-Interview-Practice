package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number.

        Input:
        The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. The first line of each test case is N and S, where N is the size of array and S is the sum. The second line of each test case contains N space separated integers denoting the array elements.

        Output:
        For each testcase, in a new line, print the starting and ending positions(1 indexing) of first such occuring subarray from the left if sum equals to subarray, else print -1.

        Constraints:
        1 <= T <= 100
        1 <= N <= 107
        1 <= Ai <= 1010

        Example:
        Input:
        2
        5 12
        1 2 3 7 5
        10 15
        1 2 3 4 5 6 7 8 9 10
        Output:
        2 4
        1 5

        Explanation :
        Testcase1: sum of elements from 2nd position to 4th position is 12
        Testcase2: sum of elements from 1st position to 5th position is 15
*/
class SubArraySumUsing2Pointer {
        public static void main (String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int tc = Integer.parseInt(br.readLine());
            while(tc>0){
                String line1[] = br.readLine().split(" ");
                int noOfElements = Integer.parseInt(line1[0]);
                int sum = Integer.parseInt(line1[1]);
                int arr[] = new int[noOfElements];
                String arr1[] = br.readLine().split(" ");
                for(int i = 0 ; i < noOfElements; i++){
                    arr[i] = Integer.parseInt(arr1[i]);
                }
                findSubArray(arr,sum);
                tc--;
            }
        }
        public static void findSubArray(int arr[], int sum){
            int init = 0;
            int currSum = 0;
            for (int i = 0; i<arr.length; i++){
                currSum += arr[i];
                if(currSum==sum){
                    System.out.println((init+1)+" "+(i+1));
                    return;
                }
                else if (currSum>sum){                   //if current sum exceeds target sum increment init i.e starting index of subarray
                    while(currSum>sum && init <=i){   //init can be maximum equal to current index . It can't be more than i because currSum
                        currSum-=arr[init];          //has sum upto value i only.
                        init++;
                        if(currSum==sum){
                            System.out.println((init+1)+" "+(i+1));
                            return;
                        }
                    }
                }
            }
            System.out.println(-1);
        }
    }






