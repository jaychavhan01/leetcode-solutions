class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        String dig = "123456789";
        for(int i = 2;i<=9;i++) {
            for(int st=0;st<=9-i;st++) {
                String sub = dig.substring(st,st+i);
                int n = Integer.parseInt(sub);
                if(n>=low && n<=high) res.add(n);
            }
        }
        return res;
    }
}