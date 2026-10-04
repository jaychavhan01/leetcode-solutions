class Solution {
    public int minimumPushes(String word) {
        int tot=0;
        for(int i=0;i<word.length();i++) {
            tot += (i/8)+1;
        }
        return tot;
    }
}