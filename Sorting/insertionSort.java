package Sorting;

import java.util.Arrays;

public class insertionSort {
    public static void main(String[] args) {
        int arr[]={10, 5, 3, 8, 15, 7, 20, 18, 12, 25, 6, 2, 30, 22, 11, 14};
        // int arr[]={-6,-64,12,100,88,0,99,77,10,2,1};
        System.out.println(Arrays.toString(insertionSortLoop(arr)));
    }

    private static int[] insertionSortLoop(int[] arr) {
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j>0;j--){
                if(arr[j]<arr[j-1]){
                    arr=swap(arr,j,j-1);
                }
                else{
                    break;
                }
            }
        }
        return arr;
    }

    private static int[] swap(int[] arr, int j, int i) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        return arr;
    }
}
