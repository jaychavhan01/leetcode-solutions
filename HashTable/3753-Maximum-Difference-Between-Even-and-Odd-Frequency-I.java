class Solution {
    public int maxDifference(String s) {
        int freq[] = new int[26];
        for(int i=0;i<s.length();i++) {
            freq[s.charAt(i)-97]++;
        }
        int odd=Integer.MIN_VALUE;
        int even=Integer.MAX_VALUE;
        for(int i=0;i<freq.length;i++) {
            if(freq[i]%2==0 && freq[i]!=0) {
               even=Math.min(freq[i],even);
            }
            else {
                if(freq[i]!=0) odd=Math.max(freq[i],odd);
            }
        }
        return odd-even;
    }
}