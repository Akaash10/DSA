package Searching;

public class binarySearch {
    public static void main(String[] args) {
        int arr[]={1,2,5,7,88,99,444,1000};
        int target=10;
        int index=binarySearchLogic(arr,target,0,arr.length-1);
        System.out.println((index==-1)?"Element not found":"Element found at index-> "+index);
    }

    private static int binarySearchLogic(int[] arr, int target, int start, int end) {
        if(start>end){
            return -1;
        }
        int middle=(start+end)/2;
        if(arr[middle]==target){
            return middle;
        }
        else if(arr[middle]<target){
            return binarySearchLogic(arr, target, middle+1, end);
        }
        else{
            return binarySearchLogic(arr, target, start, middle-1);
        }
    }
    
}

//limitation - only works over sorted array
//best case- O(1)
//average & worst case- O(log N);
