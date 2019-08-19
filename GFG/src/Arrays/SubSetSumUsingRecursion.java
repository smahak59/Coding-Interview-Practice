package Arrays;

public class SubSetSumUsingRecursion {
    public boolean subSetSum(int sum, int arr[],int i){
        if(i==arr.length){
            if(sum==0) return true;
            return false;
        }
        if(sum == 0){
            return true;
        }
        else{
            return subSetSum(sum-arr[i],arr,i+1)||subSetSum(sum,arr,i+1);
        }

    }
}
