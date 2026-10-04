class Solution {
    public boolean digitCount(String num) {
        int ar[] = new int[10];
        for(int i=0;i<num.length();i++) {
            int dig = num.charAt(i)-'0';
            ar[dig]++;
        }
        for(int i=0;i<num.length();i++) {
            int dig = num.charAt(i)-'0';
            if(ar[i]!=dig) return false;
        }
        return true;
    }
}