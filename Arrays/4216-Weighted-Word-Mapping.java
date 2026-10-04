class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for(String str:words) {
            int sum=0;
            for(int i=0;i<str.length();i++) {
                int ind = str.charAt(i)-'a';
                sum += weights[ind];
            }
            int rem = sum % 26;
            char ch = (char)(122-rem);
            sb.append(ch);
        }
        return new String(sb);
    }
}