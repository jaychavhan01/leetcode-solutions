class Solution {
    public int maxFreqSum(String s) {
        int freq[] = new int[26];
        for(int i=0;i<s.length();i++) {
            freq[s.charAt(i)-97]++;
        }
        int con=0;
        int vow=0;
        for(int i=0;i<freq.length;i++) {
            if(i==0||i==4||i==8||i==14||i==20) {
                if(freq[i]>vow) vow=freq[i];
            }
            else {
                if(freq[i]>con) con=freq[i]; 
            }
        }
        return con+vow;
    }
}