class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int maxCount=0;
        int count=0;
        for(int i : nums){
            
            if(i==1) count++;
            else {
                maxCount=Math.max(count,maxCount);
                count=0;
            }
        }
        return maxCount>count?maxCount:count;
    }
}