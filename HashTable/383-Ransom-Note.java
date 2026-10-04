class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int ar[] = new int[26];
        for(int i=0;i<magazine.length();i++) {
            int ind = magazine.charAt(i)-97;
            ar[ind]++;
        }
        for(int i=0;i<ransomNote.length();i++) {
             int ind = ransomNote.charAt(i)-'a';
             ar[ind]--;
             if(ar[ind]<0) return false;
        }
        return true;
    }
}