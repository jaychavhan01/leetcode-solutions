class Solution {
    public String intToRoman(int num) {
        int[] ar = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] sym = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<ar.length;i++) {
            while(num>=ar[i]) {
                sb.append(sym[i]);
                num -= ar[i];
            }
            if(num==0) {
                break;
            }
        }
        return sb.toString();
    }
}