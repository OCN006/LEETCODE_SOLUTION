class Solution {
    public double findMaxAverage(int[] arr, int k) {
        int i =0 , j= 0;
        double sum = 0;
        double max = Integer.MIN_VALUE;
        while (j<k) {
            sum = sum+arr[j];
            j++;
        }
        max = Math.max(sum, max);
        for ( j =k ;j< arr.length; j++) {
             sum=sum-arr[i]+arr[j];
             i++;
             max = Math.max(sum, max);
        }
        double avg = max/k;
        return avg;
    }
}