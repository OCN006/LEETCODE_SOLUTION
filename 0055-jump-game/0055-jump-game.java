class Solution {
    public boolean canJump(int[] nums) {
        int gap = 1;
        for(int i=nums.length-2; i>=0; i--) {
            if(nums[i] < gap) gap ++;
            else gap = 1;
        }
        return gap > 1 ? false : true;
    }
}