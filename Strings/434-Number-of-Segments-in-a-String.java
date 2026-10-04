class Solution {
    public int countSegments(String s) {
        String res = s.trim();
        if(res.length()==0) return 0;

        int count = 1;
        for(int i=0;i<res.length()-1;i++) {
            if(res.charAt(i)==' '&& res.charAt(i+1)!=' ') {
                count++;
            }
        }
        return count;
    }
}