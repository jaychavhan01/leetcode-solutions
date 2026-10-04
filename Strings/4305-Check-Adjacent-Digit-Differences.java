class Solution {
    public boolean isAdjacentDiffAtMostTwo(String s) {
        for(int i = 0;i<s.length()-1;i++) {
            int a = s.charAt(i);
            int b = s.charAt(i+1);
            if(Math.abs(a-b)>2) return false;
        }
        return true;
    }
}