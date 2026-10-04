class Solution {
    public String getHint(String secret, String guess) {
        int freq1[] = new int[10];
        int freq2[] = new int[10];
        for(int i=0;i<secret.length();i++) {
            freq1[secret.charAt(i)-'0']++;
            freq2[guess.charAt(i)-'0']++;
        }
        int bullCount=0;
        for(int i=0;i<secret.length();i++) {
            if(secret.charAt(i)==guess.charAt(i)) {
                bullCount++;
                freq1[secret.charAt(i)-'0']--;
                freq2[guess.charAt(i)-'0']--;
            }
        }
        int cowCount=0;
        for(int i=0;i<freq1.length;i++) {
            while(freq1[i]>0 && freq2[i]>0) {
                cowCount++;
                freq1[i]--;
                freq2[i]--;
            }
        }
        return bullCount+"A"+cowCount+"B";
    }
}