class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int i =0;
        int j=0;
        int sum =0;
        int min = Integer.MAX_VALUE;
        for(j=0;j<n;j++){
            sum=sum+nums[j];
            while(sum>=target){
                min = Math.min(j-i+1,min);
                sum=sum-nums[i];
                i++;
            }
        }
        if(min==Integer.MAX_VALUE) return 0;
        return min;
    }
}