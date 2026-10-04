class Solution {
    public boolean backspaceCompare(String s, String t) {
        char stack1[] = new char[s.length()];
        char stack2[] = new char[t.length()];

        int top1 = -1, top2 = -1;

        for (int i = 0; i < s.length(); i++) {
            //char ch = s.charAt(i);

            if (s.charAt(i) == '#') {
                if (top1 != -1) {
                    top1--;
                }
            } 
            else {
                stack1[++top1] = s.charAt(i);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            //char ch = t.charAt(i);

            if (t.charAt(i) == '#') {
                if (top2 != -1) {
                    top2--;
                }
            } 
            else {
                stack2[++top2] = t.charAt(i);
            }
        }

        if (top1 != top2) return false;

        for (int i = 0; i <= top1; i++) {
            if (stack1[i] != stack2[i]) {
                return false;
            }
        }
        return true;
    }
}