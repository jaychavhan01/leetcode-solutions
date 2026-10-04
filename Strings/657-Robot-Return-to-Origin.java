class Solution {
    public boolean judgeCircle(String moves) {
        int hmove=0,vmove=0;
        for(int i=0;i<moves.length();i++) {
            char ch = moves.charAt(i);
            if(ch=='L') hmove++;
            else if(ch=='R') hmove--;
            else if(ch=='U') vmove++;
            else if(ch=='D') vmove--;
        }
        return hmove==0 && vmove==0;
    }
}