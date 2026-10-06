class Solution {
    public int minAddToMakeValid(String s) {
        int ocount=0,ccount=0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='(') ocount++;
            else {
                if(ocount>0) ocount--;
                else ccount++;
            }
        }
        return ocount+ccount;
    }
}