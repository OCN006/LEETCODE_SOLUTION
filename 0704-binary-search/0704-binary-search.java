class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int n = binarySearch(nums , target, low ,  high);
        return n ;
    }
    public int binarySearch(int [] nums , int target,int low , int high){
        if(low>high) return -1;

        int mid = (low+high)/2;
        if(nums[mid]==target) return mid;
        if(target>nums[mid])   return binarySearch(nums , target, mid+1 , high);
        else return binarySearch(nums , target, low ,mid-1);
        
    }
}