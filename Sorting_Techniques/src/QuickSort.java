public class QuickSort {
    int arr[];
    public void sortQuick(int arr[], int low, int high) {
       if(low<high){
           int p =  partition (arr,low,high);
           sortQuick(arr,low,p-1);
           sortQuick(arr,p+1,high);
       }

    }
    int partition (int arr[],int low, int high){

        int pivot = arr[high];
        int i = low-1;
        for(int j = low; j<high; j++){
            if(arr[j]<pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }
        int temp =  arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }

    public void printArray(int arr[]){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {15,20,30,4,-1,0,-999};
       QuickSort s = new QuickSort();
        s.sortQuick(arr,0, arr.length-1);
        s.printArray(arr);
    }
}
