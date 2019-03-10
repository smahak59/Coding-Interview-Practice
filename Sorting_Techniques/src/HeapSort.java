public class HeapSort {
    int arr[];
    public void sortHeap(int arr[]) {
        this.arr = arr;
        int size = arr.length;
        for(int i = ((size/2) -1);i>=0;i-- ){
            heapify( arr, i,size);
        }
        for(int i = size-1 ; i>= 0 ;i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapify(arr, 0 , i);
        }

    }
    public void heapify (int arr[], int i, int n){
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if(left < n && arr[left] > arr[largest]){    //Don't forget that the left/right child is in the current heapsize
            largest = left;                         // It keeps on decreasing in sort heap - Left out elements are sorted
        }                                           //are put in the end of the array and not considered for heapify
        if(right < n && arr[right]>arr[largest]){
            largest = right;
        }
        if(i!=largest){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr,largest,n);                //To maintain max heap property downwards also
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
        HeapSort s = new HeapSort();
        s.sortHeap(arr);
    }
}
