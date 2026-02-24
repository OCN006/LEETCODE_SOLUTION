class Solution {
    public int maxArea(int[] arr) {
        int max=0;
         int left =0,right=arr.length-1;
        while (left<right) {
            int w = right-left;
            int h = Math.min(arr[left], arr[right]);
            int area = w*h;
            max=Math.max(max, area);
            if(arr[left]>arr[right]) right--;
            else left++;
        }
    return max;
    }
}