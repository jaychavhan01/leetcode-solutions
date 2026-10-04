class Solution {
    public int lengthOfLastWord(String s) {
        String str = s.trim();
        int i = str.length()-1;
        int sp = 0;
        boolean flag = false;
        while(i>=0) {
            if((str.charAt(i))==' ') {
                flag = true;
                sp = i;
                break;
            }
            i--;
        }
        if(flag)
        return str.length()-sp-1;
        else 
            return str.length();
    }
}