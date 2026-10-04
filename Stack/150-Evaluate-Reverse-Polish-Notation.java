class Solution {
    public int evalRPN(String[] tokens) {
        int ar[]=new int[tokens.length];
        int top=-1;
        for(int i=0;i<tokens.length;i++) {
            String token=tokens[i];
             if (!(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"))) {
                int num=Integer.parseInt(token);
                ar[++top]=num;
            }
            else {
                int b=ar[top--];
                int a=ar[top--];
                int res=0;
                if(token.equals("+")) {
                    res = a+b;
                }
                else if(token.equals("-")) {
                    res = a-b;
                }
                else if(token.equals("*")) {
                    res = a*b;
                }
                else if(token.equals("/")) {
                    res = a/b;
                }
                ar[++top]=res;
            }
        }
        return ar[top];
    }
}