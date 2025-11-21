class Solution {
    public int countPalindromicSubsequence(String s) {
        int [] first = new int[26];
        int [] last = new int[26];
        Arrays.fill(first,-1);
        Arrays.fill(last,-1);
        int n = s.length();
        for(int i = 0 ; i<n;i++){
            int c = s.charAt(i)-'a';

            if(first[c]==-1) first[c]=i;
            last[c]=i;
        }
        int count =0;
        for(int c=0;c<26;c++){
            if(first[c]==last[c]||first[c]==-1) continue;

            HashSet<Character> set = new HashSet<>();

            for (int i = first[c] + 1; i < last[c]; i++) {
                set.add(s.charAt(i));
            }

            count += set.size();
        }
         return count;

    }
}