class Solution {
    public boolean areOccurrencesEqual(String s) {
        int freq[] = new int[26];
        for(int i=0;i<s.length();i++) {
            freq[s.charAt(i)-97]++;
        }
        int occ=freq[s.charAt(0)-97];
        for(int i=0;i<freq.length;i++) {
            if(freq[i]!=0 && freq[i]!=occ) return false;
        }
        return true;
    }
}