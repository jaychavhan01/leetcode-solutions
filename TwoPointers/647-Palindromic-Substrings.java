class Solution {
    public int countSubstrings(String s) {
        int count=0;
        for(int i=0;i<s.length();i++) {
            for(int j=0;j<=i;j++) {
                int st=j;
                int end=i;
                while(st<=end) {
                    if(s.charAt(st)!=s.charAt(end)) {
                        break;
                    }
                    st++;
                    end--;
                }
                if(st>=end) count++;
            }
        }
        return count;
    }
}