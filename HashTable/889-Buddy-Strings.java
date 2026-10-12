class Solution {
    public boolean buddyStrings(String s, String goal) {
        int l1 = s.length();
        int l2=goal.length();
        if(l1!=l2) return false;

        if(s.equals(goal)) {
            int[] ar = new int[26];
            for(int i=0;i<l1;i++) {
                ar[s.charAt(i)-'a']++;

                if(ar[s.charAt(i)-'a']>1) return true;
            }
            return false;
        }

        int first=-1,second =-1;

        for (int i = 0; i < l1; i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                } else {
                    // More than 2 mismatches found
                    return false;
                }
            }
        }

        return (second!=-1 && s.charAt(first)==goal.charAt(second)&& s.charAt(second)==goal.charAt(first));

    }
}