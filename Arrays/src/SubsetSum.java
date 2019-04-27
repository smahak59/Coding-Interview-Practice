public class SubsetSum {


    public static boolean isSubsetSum(int[] arr, int i, int j, int sum) {

        if (sum == 0) {
            return true;
        } else if (i == j) {
            return arr[i] == sum;
        } else if (i < j) {
            return isSubsetSum(arr, i, j - 1, sum) || isSubsetSum(arr, i, j - 1, sum - arr[j]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] set = {3, 34, 4, 12, 7, 0};
        int sum = 45;
        int n = set.length;
        if (isSubsetSum(set, 0, n - 1, sum) == true)
            System.out.println("Found a subset"
                    + " with given sum");
        else
            System.out.println("No subset with"
                    + " given sum");
    }
}
