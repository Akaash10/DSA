package Sorting;

import java.util.*;
public class cyclicSort {
    public static void main(String[] args) {
        int arr[]={4,3,2,1,6,5,8,7,9};
        System.out.println(Arrays.toString(cyclicSortLoop(arr)));
    }

    private static int[] cyclicSortLoop(int[] arr) {
        int i=0;
        while(i<arr.length){
            if(arr[i]==i+1){
                i++;
            }
            else{
                int temp=arr[i];
                arr[i]=arr[temp-1];
                arr[temp-1]=temp;
            }
        }
        return arr;
    }
}

