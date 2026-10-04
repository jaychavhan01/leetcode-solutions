class Solution {
    public String reversePrefix(String word, char ch) {
        int ind=0;
        boolean flag = false;
        for(int i=0;i<word.length();i++) {
            if(word.charAt(i)==ch) {
                ind=i;
                flag = true;
                break;
            }
        }
        if(!flag) return word;
        StringBuilder sb = new StringBuilder();
        String s = word.substring(0,ind+1);
        int j=0,k=ind;
        char arr[] = s.toCharArray();
        while(j<k) {
            char c = arr[j];
            arr[j] = arr[k];
            arr[k] = c;
            j++;
            k--;
        }
        sb.append(arr);
        sb.append(word.substring(ind+1,word.length()));
        return sb.toString();
    }
}