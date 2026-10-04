class Solution {
    public boolean isValid(String s) {
        char arr[] = new char[s.length()];
        int top = -1;
        for(int i=0;i<s.length();i++) {
            if(top!=-1 && ((s.charAt(i)==')'&& arr[top]=='(')||(s.charAt(i)==']'&&arr[top]=='[')||(s.charAt(i)=='}'&&arr[top]=='{'))) {
                top--;
            }
            else {
                arr[++top] = s.charAt(i);
            }
        }
        if(top==-1) return true;
        else return false;
    }
}