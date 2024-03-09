package Sorting;

import java.util.*;
public class bubbleSort{
    public static void main(String[] args) {
        // int arr[]={10, 5, 3, 8, 15, 7, 20, 18, 12, 25, 6, 2, 30, 22, 11, 14};
        int arr[]={1,2,3,4};
        System.out.println(Arrays.toString(bubbleSortLogicLoop(arr, 0, arr.length-1)));
        System.out.println(Arrays.toString(bubbleSortLogicRecursion(arr,0,arr.length-1,false)));
    }

    private static int[] bubbleSortLogicLoop(int[] arr, int start, int end) {
        boolean swap;
        while(start<=end){
            swap=false;
            for(int i=start;i<end;i++){
                if(arr[i]>arr[i+1]){
                    int temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                    swap=true;
                }
            }
            --end;
            if(!swap){
                break;
            }
        }
        return arr;
    }

    private static int[] bubbleSortLogicRecursion(int[] arr,int start,int end,boolean flag) {
        if(start>=end){
            return arr;
        }
        if(arr[start]>arr[start+1]){
            int temp=arr[start];
            arr[start]=arr[start+1];
            arr[start+1]=temp;
            flag=true;
        }
        arr=bubbleSortLogicRecursion(arr, start+1, end,flag);
        if(!flag){
            return arr;    
        }
        return bubbleSortLogicRecursion(arr, start, end-1,flag);
    }
}


// In every pass, largest element moved to end
// aka sinking sort,exchange sort,inplace sort
// best case- O(N)
// worst case- O(N pow 2);