class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> list = new ArrayList<>();
        int n1 = s.length();
        int n2 = p.length();
        if(n1<n2) return list;
        int [] s_freq = new int[26];
        int [] p_freq = new int[26];
        for(int i=0;i<n2;i++){
            p_freq[p.charAt(i)-'a']++;
        }
        int k=0;
        for(int i=0;i<n2;i++){
            s_freq[s.charAt(i)-'a']++;
        }
        if(Arrays.equals(p_freq,s_freq)) list.add(k);
        for(int i=n2;i<n1;i++){
            s_freq[s.charAt(i)-'a']++;
            s_freq[s.charAt(k++)-'a']--;
            if(Arrays.equals(p_freq,s_freq)) list.add(k);
        }
        return list;
    }
}