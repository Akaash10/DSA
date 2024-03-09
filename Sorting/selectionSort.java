package Sorting;

import java.util.Arrays;

public class selectionSort {
    public static void main(String[] args) {
        //int arr[]={10, 5, 3, 8, 15, 7, 20, 18, 12, 25, 6, 2, 30, 22, 11, 14};
        int arr[]={-6,-64,12,100,88,0,99,77,10,2,1};
        System.out.println(Arrays.toString(selectionSortLogicLoop(arr, 0, arr.length-1)));
    }

    private static int[] selectionSortLogicLoop(int[] arr, int start, int end) {
        while(start<=end){
            int max=start;
            for(int i=start+1;i<=end;i++){
                if(arr[max]<arr[i]){
                    max=i;
                }
            }
            arr=swap(arr,max,end);
            --end;
        }
        return arr;
    }

    private static int[] swap(int[] arr, int max,int end) {
        int temp=arr[end];
        arr[end]=arr[max];
        arr[max]=temp;
        return arr;
    }
}
