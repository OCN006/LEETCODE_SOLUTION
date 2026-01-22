class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet<>();
        HashSet<String> RESULT = new HashSet<>();
        for (int i = 0; i <= s.length()-10; i++) {
            String c = s.substring(i, i+10);
            if (seen.contains(c)) {
                RESULT.add(c);
            }
            else{
                seen.add(c);
            }
        }
        return new ArrayList<>(RESULT);   
    }
}