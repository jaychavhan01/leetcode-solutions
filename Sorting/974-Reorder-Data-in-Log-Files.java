class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs,(a,b) -> {
            int ind1 = a.indexOf(' ');
            int ind2 = b.indexOf(' ');
            String id1 = a.substring(0,ind1);
            String id2 = b.substring(0,ind2);
            
            String content1 = a.substring(ind1+1);
            String content2 = b.substring(ind2+1);
            
            boolean isDigit1 = Character.isDigit(content1.charAt(0));
            boolean isDigit2 = Character.isDigit(content2.charAt(0));
            
            if(!isDigit1 && !isDigit2) {
                int cmp = content1.compareTo(content2);
                if(cmp!=0) return cmp;
                return id1.compareTo(id2);
            }
            
            if(!isDigit1 && isDigit2) return -1;
            
            if(isDigit1 && !isDigit2) return 1;
            
            return 0;
        });
        return logs;
    }
}