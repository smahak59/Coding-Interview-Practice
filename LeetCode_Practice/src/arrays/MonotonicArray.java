package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* An array is monotonic if it is either monotone increasing or monotone decreasing.

An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].

Return true if and only if the given array A is monotonic.*/


//Approach 1
/*
* Intuition and Algorithm

To perform this check in one pass, we want to remember if it is monotone
increasing or monotone decreasing.
It's monotone increasing if there aren't some adjacent values A[i],
A[i+1] with A[i] > A[i+1], and similarly for monotone decreasing.
If it is either monotone increasing or monotone decreasing,
then A is monotonic.*/
class Solution {
    public boolean isMonotonic(int[] A) {
        int store = 0;
        for (int i = 0; i < A.length - 1; ++i) {
            int c = Integer.compare(A[i], A[i+1]);
            if (c != 0) {
                if (c != store && store != 0)
                    return false;
                store = c;
            }
        }

        return true;
    }
}

//Approach 2
/*
* Intuition

To perform this check in one pass, we want to handle a stream of comparisons
from \{-1, 0, 1\}{−1,0,1}, corresponding
to <, ==, or >. For example, with the array [1, 2, 2, 3, 0],
we will see the stream (-1, 0, -1, 1).

Algorithm

Keep track of store, equal to the first non-zero comparison seen (if it exists.)
 If we see the opposite comparison, the answer is False.

Otherwise, every comparison was (necessarily) in the set \{-1, 0\}{−1,0},
or every comparison was in the set \{0, 1\}{0,1}, and therefore the array
is monotonic.*/
class Solution1 {
    public boolean isMonotonic(int[] A) {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < A.length - 1; ++i) {
            if (A[i] > A[i+1])
                increasing = false;
            if (A[i] < A[i+1])
                decreasing = false;
        }

        return increasing || decreasing;
    }
}

class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] A = stringToIntegerArray(line);

            boolean ret = new Solution().isMonotonic(A);
            boolean ret1 = new Solution1().isMonotonic(A);

            String out = booleanToString(ret);
            String out1 = booleanToString(ret1);

            System.out.println(out);
            System.out.println(out1);
        }
    }
}