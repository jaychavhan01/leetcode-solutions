class Solution {
    // public boolean checkPalindrome(String s) {
    //     int st = 0;
    //     int end = s.length() - 1;
    //     while (st < end) {
    //         if (s.charAt(st) != s.charAt(end))
    //             return false;
    //         st++;
    //         end--;
    //     }
    //     return true;
    // }

    public int longestPalindrome(String s) {
        int sum = 0;
        int ar[] = new int[256];
        for (int i = 0; i < s.length(); i++) {
            ar[s.charAt(i)]++;
        }
        for(int i=0;i<ar.length;i++) {
            if(ar[i]!=0 && ar[i]%2==0) {
                sum+= ar[i];
            }
            else if(ar[i]!=0 && ar[i]%2!=0) {
                sum += ar[i]-1;
            }
        }
        return Math.min(sum+1,s.length());
    }
}