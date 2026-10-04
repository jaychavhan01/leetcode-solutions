class Solution {
    public int titleToNumber(String columnTitle) {
        int num = 0;
        for(int i=0;i<columnTitle.length();i++) {
            int val = columnTitle.charAt(i)-'A'+ 1;
            num = num * 26 +val;
        }
        return num;
    }
}