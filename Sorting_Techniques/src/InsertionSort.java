public class InsertionSort {
    int arr[];
    public void sortInsertion(int arr[]) {
        this.arr = arr;
        for(int i = 1; i< arr.length; i++){
            int key = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];               //Considering previous elements are already sorted
                j--;                             // No swap
            }
            arr[j+1] = key;
        }

            printArray(arr);
    }

    public void printArray(int arr[]){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {15,20,30,4,-1,0,-999};
        InsertionSort s = new InsertionSort();
        s.sortInsertion(arr);
    }
}
