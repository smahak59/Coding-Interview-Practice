package arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
* 561. Array Partition I
Easy

547

1652

Favorite

Share
Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

Example 1:
Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
Note:
n is a positive integer, which is in the range of [1, 10000].
All the integers in the array will be in the range of [-10000, 10000].*/

public class ArrayPartition1 {
    boolean flag[];

    public int arrayPairSum(int[] nums) {
        flag = new boolean[nums.length];
        for(int i = 0; i<flag.length;i++){
            flag[i] = true;
        }
        int sum = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            sum += findSecondMax(nums);
        }
        return sum;

    }

    int findSecondMax(int arr[]) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int maxIndex = -1;
        int secondMaxIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (flag[i]) {
                if (arr[i] > max) {
                    secondMax = max;
                    max = arr[i];
                    secondMaxIndex = maxIndex;
                    maxIndex = i;

                }
                else if(arr[i]>secondMax){
                    secondMax = arr[i];
                    secondMaxIndex = i;
                }
            }
        }
        if (maxIndex != -1 && secondMaxIndex != -1) {
            flag[maxIndex] = false;
            flag[secondMaxIndex] = false;
        }
        return secondMax;
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        /*while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            int ret = new Solution().arrayPairSum(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }*/
        int[] nums = {1, 4, 3, 2};

        int ret = new ArrayPartition1().arrayPairSum(nums);

        String out = String.valueOf(ret);

        System.out.print(out);

    }
}


