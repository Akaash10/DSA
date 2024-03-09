package Searching;

public class linearSearch{
    public static void main(String[] args) {
        int arr[]={1,2,3,4,7,5};
        int target=1;
        int index=linearSearchLogic(arr,target,0,arr.length-1);
        System.out.println((index==-1)?"Element not found":"Element found at index-> "+index);
    }

    private static int linearSearchLogic(int[] arr,int target,int start,int end){
        if(start>end){
            return -1;
        }
        if(arr[start]==target){
            return start;
        }
        return linearSearchLogic(arr, target, ++start, end);
    }
}

//limitation - works over sorted and unsorted array
//best case- O(1)
//average case- O(N+1/2);
//worst case- O(N)