class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 1;
        int sumEven = 2;
        for(int i=1;i<n;i++) {
            sumOdd += i*2+1;//3
            sumEven += i*2+2; //4
        }
        //int gcd = 1;
        while(sumEven>0) {
            int rem = sumOdd%sumEven;
            sumOdd = sumEven;
            sumEven= rem;
        }
        return sumOdd;
    }
}