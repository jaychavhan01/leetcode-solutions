class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        int capcount = 0;
            for(int i=0;i<word.length();i++) {
                char ch = word.charAt(i);
                if(Character.isUpperCase(ch)) capcount++;
            }
        if(capcount==n || capcount==0 || (capcount==1 && Character.isUpperCase(word.charAt(0)))) 
            return true;

        return false;
    }
}