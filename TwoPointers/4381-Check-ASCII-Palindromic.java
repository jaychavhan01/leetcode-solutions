class Solution {
    public boolean isPalindromic(String s) {
        StringBuilder bin = new StringBuilder();

        for(char ch:s.toCharArray()) {
            int ascii = (int) ch;
            String bits = Integer.toBinaryString(ascii);

            while(bits.length()<8) {
                bits="0"+bits;
            }
            bin.append(bits);
        }
        int left = 0;
        int right=bin.length()-1;

        while(left<right) {
            if(bin.charAt(left)!=bin.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}