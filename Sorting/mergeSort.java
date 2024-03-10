package Sorting;

import java.util.*;

public class mergeSort {
    public static void main(String[] args){
        int arr[]={10, 5, 3, 8, 15, 7, 20, 18, 12, 25, 6, 2, 30, 22, 11, 14};
        // int arr[]={4,1};
        System.out.println(Arrays.toString(mergeSortLogicLoop(arr)));
    }

    public static int[] mergeSortLogicLoop(int arr[]){
        if(arr.length==1){
            return arr;
        }
        int mid=arr.length/2;
        int arr1[]=mergeSortLogicLoop(Arrays.copyOfRange(arr,0,mid));
        int arr2[]=mergeSortLogicLoop(Arrays.copyOfRange(arr,mid,arr.length));
        return mergeTwoArray(arr1,arr2);
    }

    public static int[] mergeTwoArray(int arr1[],int arr2[]){
        int arr[]=new int[arr1.length+arr2.length];
        int pointer=0,pointer1=0,pointer2=0;
        while(pointer1<arr1.length&&pointer2<arr2.length){
            if(arr1[pointer1]<arr2[pointer2]){
                arr[pointer++]=arr1[pointer1++];
            }
            else{
                arr[pointer++]=arr2[pointer2++];
            }
        }
        while(pointer1<arr1.length){
            arr[pointer++]=arr1[pointer1++];
        }
        while(pointer2<arr2.length){
            arr[pointer++]=arr2[pointer2++];
        }
        return arr;
    }
}
