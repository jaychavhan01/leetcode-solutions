class Solution {
    public boolean isPalindrome(String s) {
        int st=0,end=s.length()-1;
        while(st<end) {
            if(s.charAt(st)!=s.charAt(end)) return false;
            st++;
            end--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int max=0;
        String ans="";
        for(int i=0;i<s.length();i++) {
            for(int j=i;j<s.length();j++) {
                String str = s.substring(i,j+1);
                boolean res = isPalindrome(str);
                if(res && str.length()>max) {
                    ans=str;
                    max=str.length();
                }
            }
        }
        return ans;
    }
}