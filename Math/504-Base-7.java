class Solution {
    public String convertToBase7(int num) {
        int ar[] = new int[25];
        int i=0;
        boolean flag = true;
        if(num<0) {
            flag = false;
            num = num*(-1);
        }
        while(num>0) {
            ar[i]=num%7;
            num /= 7;
            i++;
        }
        i--;
        int n=0;
        while(i>=0) {
        ;
            n = n*10+ar[i];
            i--;
        }
        if(flag) return Integer.toString(n);
        n = n*-1;
        return Integer.toString(n);
    }
}