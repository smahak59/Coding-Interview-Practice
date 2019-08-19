package recursion;

import java.util.Arrays;

/*
* 698. Partition to K Equal Sum Subsets
Medium
Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.



Example 1:

Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.

//https://www.youtube.com/watch?v=O17fztIRR3I --> To understand backtracking in this question
//See leetcode official solution for further optimizations --> This is not fully optimized

Note:

1 <= k <= len(nums) <= 16.
0 < nums[i] < 10000.*/
public class PartitionIntoKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {

        int subSets[] = new int[k];
        Arrays.sort(nums);   //Optimization --> Start with largest number as subsets will be formed sooner.

        int sum = Arrays.stream(nums).sum();
        if(sum%k == 0)
            return canPartition(nums,nums.length-1,subSets,sum/k);
        else
            return false;
    }
    public boolean canPartition(int nums[], int start, int subSets[], int target){

        if(start<0)
            return true;

        int val = nums[start];
        for(int i = 0; i<subSets.length;i++){
            if(subSets[i]+val<=target){
                subSets[i]+=val;
                if(canPartition(nums,start-1,subSets,target)) return true;
                subSets[i]-=val;
            }
            if(subSets[i] == 0) break;  //Optimization when a value is not getting placed in an empty subset
                                        //It won't be able to get placed in subset[i+1] also. Hence break .
        }
        return false;
    }
}

