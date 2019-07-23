package Arrays;

import java.util.*;
import java.lang.*;
import java.io.*;
/*
* Description

The rhyme scheme for a poem (or stanza of a longer poem) tells which lines of the poem rhyme with which other lines. For example, a limerick such as If computers that you build are quantum
Then spies of all factions will want 'em
Our codes will all fail
And they'll read our email
`Til we've crypto that's quantum and daunt 'em

Jennifer and Peter Shor (http://www.research.att.com/~shor/notapoet.html)

Has a rhyme scheme of aabba, indicating that the first, second and fifth lines rhyme and the third and fourth lines rhyme.
For a poem or stanza of four lines, there are 15 possible rhyme schemes:
aaaa, aaab, aaba, aabb, aabc, abaa, abab, abac, abba, abbb, abbc, abca, a bcb, abcc, and abcd.
Write a program to compute the number of rhyme schemes for a poem or stanza of N lines where N is an input value.
Input

Input will consist of a sequence of integers N, one per line, ending with a 0 (zero) to indicate the end of the data. N is the number of lines in a poem.
Output

For each input integer N, your program should output the value of N, followed by a space, followed by the number of rhyme schemes for a poem with N lines as a decimal integer with at least 12 correct significant digits (use double precision floating point for your computations).
Sample Input

1
2
3
4
20
30
10
0
Sample Output
1 1
2 2
3 5
4 15
20 51724158235372
30 846749014511809120000000
10 115975*/
class RhymeSchemes
{
    public static final int CHAR_SIZE = 26;
    public static void main (String[] args) throws Exception
    {
        int n = 5;
        List<String> permutations = new ArrayList<>();
        generatePermutations(n, "", permutations);

        List<String> schemes = new ArrayList<>();
        for(int i = 0; i < permutations.size(); i++){
            boolean flag = true;
            for(int j = 0; j < schemes.size(); j++){
                flag = flag && areDifferent(permutations.get(i), schemes.get(j));
                if(!flag)
                    break;
            }
            if(flag)
                schemes.add(permutations.get(i));
        }

        System.out.println("Number of possible rhyming schemes with " + n + " are " + schemes.size());

        for(String ans : schemes){
            System.out.println(ans);
        }
    }

    public static boolean areDifferent(String first, String second){
        int len = first.length();

        Map<Character, Character> mp = new HashMap<>();
        for(int i = 0; i < len; i++){
            char c1 = first.charAt(i);
            char c2 = second.charAt(i);

            if(mp.get(c1) != null && mp.get(c1) != c2)
                return true;
            mp.put(c1, c2);
        }

        boolean[] vis = new boolean[CHAR_SIZE];
        for(Character c : mp.keySet()){     //2 character same key se map hogye   //AABD --- CCCC
            char mappedChar = mp.get(c);
            if(vis[mappedChar - 'a'])
                return true;
            vis[mappedChar - 'a'] = true;
        }
        return false;
    }

    public static void generatePermutations(int n, String res, List<String> permutations){
        if(res.length() == n){
            permutations.add(res);
            return;
        }

        for(int i = 0; i < n; i++){
            String newres = res + (char)(i + 'a');
            generatePermutations(n, newres, permutations);
        }
    }
}