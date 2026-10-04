class Solution {
    public String removeDuplicates(String s) {
        char arr[] = new char[s.length()];
        int top = -1;
        for(int i=0;i<s.length();i++) {
            if(top!=-1 && s.charAt(i)==arr[top]) {
                top--;
            }
            else {
                arr[++top] = s.charAt(i);
            }
        }
        // this will return string start from arr[0] to top
        
        return new String(arr, 0, top+1); 
    }
}