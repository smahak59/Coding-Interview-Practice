public class SelectionSort {

    int arr[];
    public void sortSelection(int arr[]) {
        this.arr = arr;
        for(int i =0 ; i < arr.length; i++) {
            int min_indx = i;
            for(int j=i+1; j< arr.length; j++ ) {
                 if(arr[j]<arr[min_indx]){
                    min_indx = j;
                 }
            }
            int temp = arr[min_indx];
            arr[min_indx] = arr[i];
            arr[i] = temp;
            //To see every step of sorting - end one is the result.
            printArray(arr);
        }
    }

    public void printArray(int arr[]){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {15,20,30,4,-1,0,-999};
        SelectionSort s = new SelectionSort();
        s.sortSelection(arr);
    }
}
