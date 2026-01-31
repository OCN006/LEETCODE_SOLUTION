class Solution {
    public int findKthPositive(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        
       
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            
            int missingNumbersTillNow = arr[mid] - (mid + 1);
            
            if (missingNumbersTillNow < k) {
                
                start = mid + 1;
            } else {
               
                end = mid - 1;
            }
        }
        
        
        return k + start;
    }
}