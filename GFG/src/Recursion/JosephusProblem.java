package Recursion;

class JosephusProblem
{
    public int josephus(int n, int k)
    {
        if(n==1){
            return 1;
        }else{
            return k+josephus(n-1,k) > n ?(k-1+josephus(n-1,k))%n+1:k+josephus(n-1,k);
            // suppose n = 5 and k=2
            //1 2 3 4 5
            // in first turn 2 dies left ones are 1 3 4 5 with knife in 3s hands .
            // if we number them again
            //3 --> 1 4-->2 5-->3  and 1 -->4
            //We compute josephus(n-1) where 1 is considered to hsve dagger but in our case 3 is having
            //so we need to take josephues(n-1) and convert it according to our answer.
            //For specific solution for k = 2 https://www.youtube.com/watch?v=uCsD3ZGzMgE

        }
    }
}
