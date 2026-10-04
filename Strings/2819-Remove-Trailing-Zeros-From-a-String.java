class Solution {
    public String removeTrailingZeros(String num) {
        int i = num.length()-1;
        int li = num.length();
        while(num.charAt(i)=='0') {
            li--;
            i--;
        }
        return num.substring(0,li);
    }
}