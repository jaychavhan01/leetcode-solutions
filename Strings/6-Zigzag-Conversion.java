class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1||numRows>=s.length()) {
            return s;
        }
        StringBuilder rows[] = new StringBuilder[Math.min(s.length(),numRows)];
        for(int i=0;i<rows.length;i++) {
            rows[i]=new StringBuilder();
        }
        int cRow=0;
        boolean gDown=false;

        for(char c:s.toCharArray()) {
            rows[cRow].append(c);
            if(cRow==0||cRow==numRows-1) gDown=!gDown;
            cRow += gDown?1:-1;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }
}