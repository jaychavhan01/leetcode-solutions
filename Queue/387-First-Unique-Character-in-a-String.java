class Solution {
    public int firstUniqChar(String s) {
        int ar[] = new int[26];
        
        // 1. Count frequencies
        for(int i = 0; i < s.length(); i++) {
            int ind = s.charAt(i) - 'a';
            ar[ind]++;
        }
        for(int i = 0; i < s.length(); i++) {
            int ind = s.charAt(i) - 'a';
            if(ar[ind] == 1) {
                return i; 
            }
        }
        
        return -1;
    }
}
