package Recursion;
import java.util.*;


/*
* Given a string S. The task is to print all permutations of a given string.

Input Format:
The first line of input contains an integer T, denoting the number of test cases.
Each test case contains a single string S in capital letter.

Output Format:
For each test case, print all permutations of a given string S with single space
and all permutations should be in lexicographically increasing order.

Your Task:
This is a function problem. You only need to complete the function permutation
that takes S as parameter and prints the permutations in lexicographically increasing order.
The newline is automatically added by driver code.

Constraints:
1 ≤ T ≤ 100
1 ≤ size of string ≤ 5

Example:
Input:
2
ABC
ABSG

Output:
ABC ACB BAC BCA CAB CBA
ABGS ABSG AGBS AGSB ASBG ASGB BAGS BASG BGAS BGSA BSAG BSGA GABS GASB
GBAS GBSA GSAB GSBA SABG SAGB SBAG SBGA SGAB SGBA

Explanation:
Testcase 1: Given string ABC has permutations in 6 forms as ABC, ACB, BAC, BCA, CAB and CBA .*/
class Permutation
{
    public void StringPermutations(String S)
    {
        //Your code here
        char strArray[] = S.toCharArray();
        Arrays.sort(strArray);
        StringBuilder sb = new StringBuilder();
        for(char ch: strArray) sb.append(ch);
        String res = "" ;
        permutation(sb.toString(),res);
    }

    public void permutation( String str,String res){

        if(str.equals("")){
            System.out.print(res+" "); return;
        }
        else{
            for(int i = 0; i<str.length();i++){
                permutation(str.substring(0,i)+str.substring(i+1,str.length()),res+str.charAt(i));
            }
        }

    }
    private void permute(String str, int l, int r)
    {
        if (l == r)
            System.out.println(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }
    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

}
