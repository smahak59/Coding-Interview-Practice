package arrays;
/*
* 414. Third Maximum Number
Easy
Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.
*/

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        long max = Long.MIN_VALUE, max2 = Long.MIN_VALUE, max3 = Long.MIN_VALUE;
        boolean found = false;
        for(int elem : nums){
            if(elem>max){
                max3 = max2;
                max2 = max;
                max = elem;
            }else if(elem>max2 && elem != max){
                max3 = max2;
                max2 = elem;
            }else if(elem > max3 && elem !=  max2 && elem!= max){
                max3 = elem;
                found = true;
            }
        }
        if(max3 == Long.MIN_VALUE){
            return (int)max;
        }
        return (int)max3;
    }

    //Can be done using heap also.

    // With heap used set to check if the item is already added in the heap, FYI heap.contains is o(n)
    public int thirdMaxNumber(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0; i< nums.length; i++){
            if(!set.contains(nums[i])){
                heap.add(nums[i]);
                set.add(nums[i]);
            }

            if(heap.size() > 3){
                heap.remove();
            }
        }

        System.out.println(heap);

        if(heap.size() < 3){
            int max = 0;
            while(!heap.isEmpty()){
                max = heap.remove();
            }
            return max;
        }

        return heap.peek();
    }
}
