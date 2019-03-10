public class MergeSort {
    int arr[];
    public void sortMerge(int arr[], int low, int high) {
        if(low<high){
            int mid = (low+high)/2;
            sortMerge(arr,low,mid);
            sortMerge(arr,mid+1,high);
            merge(arr,mid,low,high);

        }

    }
    public void merge(int arr[],int mid, int low,int high){
        int n1 = mid-low+1;
        int n2 = high - mid;
        int l1 [] = new int [n1];
        int r1[] = new int [n2];
        
        // Had forgotten to fill l1 and r1
        for (int i = 0 ; i < n1 ; i++)
        {
            l1[i] = arr[low+i];
        }
        for (int j = 0 ; j < n2 ; j++)
        {
            r1[j] = arr[mid+1+j];
        }
        int i = 0;
        int j = 0;
        int k = low;             // Did mistake by making it 0
        while(i<n1 && j< n2){    //Did mistake while defining upper bound as mid and high
            if(l1[i]<=r1[j]){
                arr[k] = l1[i];
                i++;
            }
            else{
                arr[k] = r1[j];
                j++;
            }
            k++;
        }
        while(i<n1) {
            arr[k] = l1[i];
            i++;
            k++;
        }
      while(j<n2){
            arr[k] = r1[j];
            j++;
            k++;
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
        MergeSort s = new MergeSort();
        s.sortMerge(arr,0, arr.length-1);
        s.printArray(arr);
    }
}

