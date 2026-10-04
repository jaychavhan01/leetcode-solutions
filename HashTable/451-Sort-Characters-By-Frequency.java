class Solution {
    public String frequencySort(String s) {
        int freq[] = new int[123];
        int max=0;
        for(int i=0;i<s.length();i++) {
            int ind = s.charAt(i);
            freq[ind]++;
            max = Math.max(max,freq[ind]);
        }
        StringBuilder sb = new StringBuilder("");
        while(max>0) {
            for(int i=48;i<freq.length;i++) {
                if(freq[i]==max) {
                    char ch = (char)i;
                    for(int j = 0; j < max; j++) {
                        sb.append(ch);
                    }
                    freq[i]=0;
                }
            }
            max--;
        }
        return sb.toString();

    }
}