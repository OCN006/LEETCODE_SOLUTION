class Solution {
    public int totalFruit(int[] fruits) {
         int i =0,j=0,count=0,max=0;
        int n = fruits.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        while (j<n) {
            map.put(fruits[j], map.getOrDefault(fruits[j], 0)+1);
            while (map.size()>2) {
                map.put(fruits[i], map.get(fruits[i])-1);
                if(map.get(fruits[i])==0){
                    map.remove(fruits[i]);
                    
                }   
                i++;
            }
             max=Math.max(max, j-i+1);
             j++;
        }
       return max;
    }
}