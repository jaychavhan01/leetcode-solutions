class Solution {
    public int maximumLengthSubstring(String s) {
        int freq[] = new int[26];
        int max=0;
        int left=0;
        for(int i=0;i<s.length();i++) {
            char ch=s.charAt(i);
            freq[ch-'a']++;

            while(freq[ch-'a']>2) {
                char c=s.charAt(left);
                freq[c-'a']--;
                left++;
            }
            max = Math.max(max,i-left+1);
        }
        return max;
    }
}