class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int freq[]=new int[26];
        for(int i=0;i<s1.length();i++) {
            int ind = s1.charAt(i)-'a';
            freq[ind]++;
        }
        int size=s1.length();
        for(int i=0;i<s2.length();i++) {
            int wind=0,ind=i;
            int win[]=new int[26];
            while(wind<size && ind<s2.length()) {
                win[s2.charAt(ind)-'a']++;
                wind++;
                ind++;
            }
            if((Arrays.equals(win,freq))) return true;
        }
        return false;
    }
}