class Solution {
    public String reorderSpaces(String text) {
        int spcount = 0;
        String str = text.trim();
        for(int i=0;i<text.length();i++) {
            if(text.charAt(i)==' ') {
                spcount++;
            }
        }
        String[] words = text.trim().split("\\s+");

        if(words.length==1) {
            StringBuilder sb = new StringBuilder(words[0]);
            for(int i=0;i<spcount;i++) {
                sb.append(" ");
            }
            return sb.toString();
        }
        int spbe = spcount/(words.length-1);
        int esp = spcount%(words.length-1);

        StringBuilder gap = new StringBuilder();
        for(int i=0;i<spbe;i++) {
            gap.append(" ");
        }
        StringBuilder res = new StringBuilder();
        for(int i=0;i<words.length;i++) {
            res.append(words[i]);

            if(i!=words.length-1) {
                res.append(gap);
            }
        }
        for(int i=0;i<esp;i++) {
            res.append(" ");
        }
        return res.toString();
    }
}