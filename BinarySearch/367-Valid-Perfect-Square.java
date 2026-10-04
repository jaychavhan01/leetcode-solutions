class Solution {
    public boolean isPerfectSquare(int num) {
        int sq = (int)Math.sqrt(num);
        if(num==sq*sq) return true;
        return false;
    }
}