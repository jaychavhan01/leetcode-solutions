class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char lo = '+';
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);

            if(Character.isDigit(c)) {
                num = 10*num+(c-'0');
            }
            
            if((!Character.isDigit(c) && c!=' ')|| i==s.length()-1) {
                if(lo == '+') stack.push(num);
                else if(lo=='-') stack.push(-num);
                else if(lo=='*') stack.push(stack.pop()*num);
                else if(lo=='/') stack.push(stack.pop()/num);
                lo=c;
                num=0;
            }
        }
        int res=0;
        for(int i:stack) {
            res += i;
        }
        return res;
    }
}