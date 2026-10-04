class Solution {
    public int maxNumberOfBalloons(String text) {
        int ar[] = new int[26];
        for(int i=0;i<text.length();i++) {
            int ind = text.charAt(i)-'a';
            ar[ind]++;
        }
        int count = 0;
        while(ar[0]>0 && ar[1]>0&&ar[13]>0 && ar[11]>1 && ar[14]>1) {
            count++;
            ar[0]--;
            ar[1]--;
            ar[13]--;
            ar[11] = ar[11]-2;
            ar[14] = ar[14]-2;
        }
        return count;
    }
}