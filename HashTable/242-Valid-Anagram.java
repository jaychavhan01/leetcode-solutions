import java.util.Arrays;
class Solution {
    public boolean isAnagram(String s, String t) {
        char ar1[] = new char[s.length()];
        char ar2[] = new char[t.length()];
        for(int i=0;i<ar1.length;i++) {
            ar1[i] = s.charAt(i);
        }
        for(int i=0;i<ar2.length;i++) {
            ar2[i] = t.charAt(i);
        }
        Arrays.sort(ar1);
        Arrays.sort(ar2);
        String s1 = new String(ar1);
        String s2 = new String(ar2);
        return s1.equals(s2);
    }
}