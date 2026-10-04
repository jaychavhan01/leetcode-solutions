class Solution {
    public int getLeastFrequentDigit(int n) {
        int ar[] = new int[10];
        while(n>0) {
            int ld = n%10;
            ar[ld]++;
            n/=10;
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<ar.length;i++) {
            if(ar[i]<min && ar[i]!=0) {
                min=ar[i];
            }
        }
        for(int i=0;i<ar.length;i++) {
            if(ar[i]==min && min!=0) {
                return i;
            }
        }
        return -1;
    }
}