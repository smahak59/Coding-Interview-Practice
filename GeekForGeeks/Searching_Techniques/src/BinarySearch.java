public class BinarySearch {


    public int bSearchRec(int ele, int low, int high,int arr[]){
        if(low<=high)
        {
            int mid = low +(high - low) / 2;   //instead of (high+low)/2 to prevent overflow
            if(arr[mid] == ele){
               return mid;
            }
            if (arr[mid] > ele){
               return bSearchRec(ele, low,mid-1,arr);  //need return here
            }
           else {
               return bSearchRec(ele, mid+1,high,arr);
           }
        }
        return -1;

    }
    public int bSearchItr(int ele,int arr[], int low, int high){
        while(low <= high){
            int mid = low +(high - low) / 2;    //instead of (high+low)/2 to prevent overflow
            if(arr[mid] == ele){
                return mid;
            }
            if (arr[mid] > ele){
               high = mid -1;
            }
            else {
                low = mid+1;
            }
        }
        return -1;
    }
    public void printArray(int arr[]){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 10, 40 };
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.bSearchItr(40, arr, 0 , arr.length-1));
        System.out.println(bs.bSearchRec(40, 0, arr.length-1, arr));

    }
}
