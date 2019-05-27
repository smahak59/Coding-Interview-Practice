import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/*
* Given an array arr and a number K where K is smaller than size of array, the task is to find the K’th smallest element in the given array. It is given that all array elements are distinct.

Worst Case Time Complexity: O(n)

//TODO : Use HeapSort nd all

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
15*/

public class KthSmallestElementWorstCaseLinear {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc > 0) {
            int num = Integer.parseInt(br.readLine());
            int[] arr = new int[num];
            String[] strArr = br.readLine().split(" ");
            for (int i = 0; i < num; i++) {
                arr[i] = Integer.parseInt(strArr[i]);
            }
            int k = Integer.parseInt(br.readLine());
            int m = findElement(arr, k-1, 0, arr.length - 1);
            System.out.println(m);
            tc--;
        }
    }

    public static int findElement(int[] arr, int k, int l, int r) {

        int pivot = findPivot(arr, l, r);
        int i = partition(arr, l, r, pivot);
        if (i == k) {
            return arr[i];
        } else if (i < k) {
            return findElement(arr, k, i + 1, r);
        } else {
            return findElement(arr, k, 0, i - 1);
        }

    }

    static int findPivot(int[] arr, int l, int r) {
        int[] median = new int[(r - l + 5) / 5];
        int index = 0;
        for (int start = l; start <= r; start += 5) {
            int end = start + 4 < r ? start + 4 : r;
            median[index] = findMedian(arr, start, end);
            index++;
        }
        return index == 1 ? median[index - 1] : findPivot(median, 0, median.length - 1);
    }

    static int findMedian(int[] arr, int start, int end) {

        Arrays.sort(arr, start, end+1); // Sort the arra
        return arr[(end - start) / 2 + start]; // Return middle element

    }

    static int partition(int[] arr, int l, int r, int pivot) {
        for (int i = l; i <= r; i++) {
            if (arr[i] == pivot) {
                int temp = arr[i];
                arr[i] = arr[r];
                arr[r] = temp;
                break;

            }
        }
        int x = arr[r];
        int j = l-1;
        for (int i = l; i < r; i++) {
            if (arr[i] < x) {
                j++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;

            }
        }
        int temp = arr[j + 1];
        arr[j + 1] = arr[r];
        arr[r] = temp;
        return j + 1;
    }
}
