class Solution {
    public String reverseWords(String s) {

        StringBuilder str = new StringBuilder();

        int st = 0;

        for(int i = 0; i < s.length(); i++) {

            if(s.charAt(i) == ' ') {

                for(int j = i - 1; j >= st; j--) {
                    str.append(s.charAt(j));
                }

                str.append(' ');
                st = i + 1;
            }
        }

        for(int i = s.length() - 1; i >= st; i--) {
            str.append(s.charAt(i));
        }

        return str.toString();
    }
}