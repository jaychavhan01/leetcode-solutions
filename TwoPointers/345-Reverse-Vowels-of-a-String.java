class Solution {
    public String reverseVowels(String s) {
        char ar[] = s.toCharArray();
        int i = 0;
        int j = ar.length-1;
        while(i<j) {
            if((ar[i]=='a'||ar[i]=='e'||ar[i]=='i'||ar[i]=='o'||ar[i]=='u'||ar[i]=='A'||ar[i]=='E'||ar[i]=='I'||ar[i]=='O'||ar[i]=='U')&&(ar[j]=='a'||ar[j]=='e'||ar[j]=='i'||ar[j]=='o'||ar[j]=='u'||ar[j]=='A'||ar[j]=='E'||ar[j]=='I'||ar[j]=='O'||ar[j]=='U')) {
                char temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
                i++;
                j--;
            }
            else if(ar[i]=='a'||ar[i]=='e'||ar[i]=='i'||ar[i]=='o'||ar[i]=='u'||ar[i]=='A'||ar[i]=='E'||ar[i]=='I'||ar[i]=='O'||ar[i]=='U') {
                j--;
            }
            else if(ar[j]=='a'||ar[j]=='e'||ar[j]=='i'||ar[j]=='o'||ar[j]=='u'||ar[j]=='A'||ar[j]=='E'||ar[j]=='I'||ar[j]=='O'||ar[j]=='U') {
                i++;
            }
            else {
                i++;
                j--;
            }
        }
        String str = new String(ar);
        return str;
    }
}