class Solution {
    public String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            char ch;
            if(i%2==0) ch = s.charAt(i);
            else {
                int val = s.charAt(i)-48;
                ch = (char)(s.charAt(i-1)+val);
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}