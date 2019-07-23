package Recursion;


// Initial Template for Java
/*package whatever //do not write package name here */
import java.io.*;
import java.util.*;
class Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            Hanoi obj = new Hanoi();
            obj.moves = 0;
            int N=3;

            obj.toh(N, 1, 3, 2, obj.moves);
            System.out.println(obj.moves);
        }
    }
}


/*This is a function problem.You only need to complete the function given below*/
// User function Template for Java
class Hanoi {
    public long moves;
    public void toh(int N, int from, int to, int aux, long moves) {
        // Your code here
        if(N==1){
            System.out.println("move disk " + N + " from rod "+ from + " to rod "+ to);
            this.moves++;

        }
        else{
            toh(N-1,from,aux,to,moves);
            System.out.println("move disk " + N + " from rod "+ from + " to rod "+ to);
            this.moves++;
            toh(N-1,aux,to,from,moves);

        }
    }
}