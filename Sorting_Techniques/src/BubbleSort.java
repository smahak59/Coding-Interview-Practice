public class BubbleSort {
    int arr[];
    public void sortBubble(int arr[]) {
        this.arr = arr;
        for(int i =0 ; i < arr.length; i++) {
            boolean swapped = false;
            for(int j = 0 ; j < arr.length-i-1; j++){
                if(arr[j]>arr[j+1]){
                    swapped = true;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            //To see every step of sorting - end one is the result.
            printArray(arr);
            if(!swapped){
                System.out.println("Final sorted array"+"\n");
                printArray(arr);
                break;
            }

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
        BubbleSort s = new BubbleSort();
        s.sortBubble(arr);
    }
}
