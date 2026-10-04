class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int count=0;
        for(int i=left;i<=right;i++) {
            String str = words[i];
            char st=str.charAt(0);
            char end=str.charAt(str.length()-1);
            if((st=='a'||st=='e'||st=='i'||st=='o'||st=='u')&&(end=='a'||end=='e'||end=='i'||end=='o'||end=='u')) count++;
        }
        return count;
    }
}