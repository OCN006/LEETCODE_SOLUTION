class Solution {
    public int countTriples(int n) {
        int count  = 0;

        for(int a=1; a<n; a++){
            for(int b=1; b<n; b++){
                int c_square = (a*a) + (b*b);
                int c = (int)Math.sqrt( c_square );
                if( (c*c)==c_square && c<=n ) count++;
            }
        }
        return count;
    }
}