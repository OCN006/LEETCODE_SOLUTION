class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int i =0,j=0,sum=0,count=0;
        int n = arr.length;
        while(j<k){
            sum=sum+arr[j];
            j++;
        }
        if(sum>=k*threshold) count++;
        for(j=k;j<n;j++){
            sum=sum+arr[j]-arr[i];
            i++;
            if(sum>=k*threshold) count++;
        }
        return count;
    }
}