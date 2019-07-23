package Recursion;
/*
*
* Given a keypad as shown in diagram, and an N digit number.
* List all words which are possible by pressing these numbers.



Input Format:
The first line of input contains an integer T denoting the number of test cases.
T testcases follow. Each testcase contains two lines of input.
The first line of each test case is N, N is the number of digits.
The second line of each test case contains D[i], N number of digits.

Output Format:
Print all possible words from phone digits with single space.

Your Task:
This is a function problem.
You just need to complete the function possibleWords that takes an array as parameter
and prints all the possible words. The newline is automatically added by the driver code.

Constraints:
1 <= T <= 10
1 <= N <= 10
2 <=  D[i] <= 9

Example:
Input:
2
3
2 3 4
3
3 4 5

Output:
adg adh adi aeg aeh aei afg afh afi bdg bdh bdi beg beh bei bfg bfh bfi cdg cdh cdi ceg ceh cei cfg cfh cfi
dgj dgk dgl dhj dhk dhl dij dik dil egj egk egl ehj ehk ehl eij eik eil fgj fgk fgl fhj fhk fhl fij fik fil

 */
class PhoneDigit
{
    static String alphabetsOnDigit[] = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    static void possibleWords(int a[], int N)
    {
        String res = "";
        generatePermutations(a, 0, res);
        // your code here
    }
    static void generatePermutations(int a[], int i, String res){

        if(i==a.length){
            System.out.print(res+" ");
        }

        else{
            String str = alphabetsOnDigit[a[i]-2];
            for(int j = 0; j<str.length(); j++){
                generatePermutations(a,i+1,res+str.charAt(j));
            }

        }
    }
}
