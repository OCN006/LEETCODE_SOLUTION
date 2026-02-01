class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        int count=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='(') {
                count++;
                max=Math.max(max,count);
                }
            if(s.charAt(i)==')'){
                count--;
            }    
        }
        if(max==Integer.MIN_VALUE) return 0;
        return max;
    }
}