package Arrays;/*
* Given an array of N distinct elementsA[ ]. The task is to find the minimum number of swaps required to sort the array. Your are required to complete the function which returns an integer denoting the minimum number of swaps, required to sort the array.

Input:
The first line of input contains an integer T denoting the no of test cases . Then T test cases follow . Each test case contains an integer N denoting the no of element of the array A[ ]. In the next line are N space separated values of the array A[ ] .

Output:
For each test case in a new line output will be an integer denoting  minimum umber of swaps that are  required to sort the array.

Constraints:
1 <= T <= 100
1 <= N <= 103
1 <= A[] <= 104


User Task: Your task is to complete minSwaps() which should return number of swaps required to make the array elements sorted.

Example(To be used only for expected output):
Input:
2
4
4 3 2 1
5
1 5 4 3 2

Output:
2
2

Explanation:
Testcase 1: We need two swaps, swap 1 with 4 and 3 with 2 to make it sorted.*/
import java.util.*;
class MinSwaps{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] a=new int[n];
            for(int i = 0; i<n ; i++){
                a[i]=sc.nextInt();
            }
            GfG g=new GfG();
           // System.out.println();
           // System.out.println(g.minSwaps(a,n));
           // System.out.println();
            System.out.print(g.findMinSwapsToSort(a));
        }
    }
}


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/


class GfG
{

    //My Solution --> logic is same as cycle only
    public static int minSwaps(int[] A, int N){
        int j = 0;
        int valuePos[] = new int[N];
        HashMap<Integer, Integer>  newPos = new HashMap<Integer,Integer>();
        for(int num:A){
            valuePos[j] = num;
            j++;
        }
        Arrays.sort(valuePos);
        for(int i = 0; i< valuePos.length;i++){
            newPos.put(valuePos[i],i);
        }
        int swap = 0;
        for(int i = 0 ; i<A.length;i++){
            if(i == newPos.get(A[i]))
                continue;
            else{
                int temp = A[i];
                A[i] = A[newPos.get(A[i])];
                A[newPos.get(temp)] = temp;
                swap++;
                if(i!=newPos.get(A[i])) i--;  //Working as  while (val != i) loop in cycle solution

            }
        }
        return swap;
    }

    //Optimal Solution using cycles - see https://stackoverflow.com/questions/
    // 15152322/compute-the-minimal-number-of-swaps-to-order-a-sequence/15152602#15152602

    public int findMinSwapsToSort(int[] ar) {
        int n = ar.length;
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            m.put(ar[i], i);
        }
        Arrays.sort(ar);
        for (int i = 0; i < n; i++) {
            ar[i] = m.get(ar[i]);
        }
        m = null;
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            int val = ar[i];
            if (val < 0) continue;
            while (val != i) {
                int new_val = ar[val];
                ar[val] = -1;
                val = new_val;
                swaps++;
            }
            ar[i] = -1;
        }
        return swaps;
    }
}