class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int totalCount=0;
        char ar[] = allowed.toCharArray();
        for(String str: words) {
            int count=0;
            for(int i=0;i<str.length();i++) {
                char ch = str.charAt(i);
                for(int j=0;j<ar.length;j++) {
                    if(ch==ar[j]) {
                        count++;
                        break;
                    }
                }
            }
            if(count==str.length()) totalCount++;
        }
        return totalCount;
    }
}