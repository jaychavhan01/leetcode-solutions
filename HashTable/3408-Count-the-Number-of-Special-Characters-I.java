class Solution {
    public int numberOfSpecialChars(String word) {
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<word.length();i++) {
            set.add(word.charAt(i));
        }
        for(int i=97;i<=122;i++) {
            int j = i-32;
            if(set.contains((char)i)&&set.contains((char)j)) {
                count++;
            }
        }
        return count;
    }
}