class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        //int count=0;
        //String res = sentences.trim();
        for(int i=0;i<sentences.length;i++) {
            //String res = sentences[i].trim();
            //count=1;
        //    for(int j=0;j<res.length();j++) {
        //     if(res.charAt(j)==' ') {
        //         count++;
        //     }
           //}
          // String[] res = (sentences[i].split(" ")).length;
           max = Math.max(max,(sentences[i].split(" ")).length);
            //max = Math.max(max, s.split(" ").length);
        }
        return max;
    }
}