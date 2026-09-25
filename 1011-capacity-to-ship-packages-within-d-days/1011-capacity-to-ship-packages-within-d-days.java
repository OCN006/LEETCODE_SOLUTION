class Solution {

    public boolean canShip(int[] weights, int days , int capacity){
        int usedDays = 1 ;
        int current  = 0;
        for(int weight : weights){
            if(current + weight >capacity){
                usedDays++;
                current = weight;
            }
            else {
                current+=weight;
            }
        }
        return usedDays<=days;
    }


    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = 0;
        int sumWeight = 0;
        int ans = 0;
        for(int weight : weights){
            maxWeight = Math.max(weight , maxWeight);
            sumWeight+=weight;
        }            
        while(maxWeight<=sumWeight){
            int mid = maxWeight + (sumWeight-maxWeight)/2;
            if(canShip(weights,days,mid)){
                 ans = mid;
                 sumWeight = mid-1;
            }
            else{
                maxWeight = mid+1;
            }
        }
        return ans ;
    }
}