class Solution {
    public boolean isIsomorphic(String s, String t) {

        int ar1[] = new int[256];
        int ar2[] = new int[256];

        for(int i=0;i<s.length();i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(ar1[c1]!=ar2[c2]) return false;
            ar1[c1] = i+1;
            ar2[c2] = i+1;
            
        }

        return true;
    }
}