class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totalSum = 0;

        if(n==k){
            for(int i=0; i<n; i++){
                totalSum+=cardPoints[i];
            }
            return totalSum;
        }

        int leftSum = 0;
        int rightSum = 0;
        int max = 0;

        for(int i=0; i<k; i++){
            leftSum+=cardPoints[i];
        }
        max = leftSum;

        int leftPointer = k-1;
        int rightPointer = n-1;


        while(leftPointer>=0){
            leftSum-= cardPoints[leftPointer];
            rightSum+=cardPoints[rightPointer];
            rightPointer--;
            leftPointer--;
            max = Math.max(max, leftSum+rightSum);
        }

        return max;
    }
}