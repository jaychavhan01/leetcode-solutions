class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cd = 0;
        int ck = 0;
        while(cd<g.length && ck<s.length) {
            if(s[ck]>=g[cd]) {
                cd++;
            }
            ck++;
        }
        return cd;
    }
}