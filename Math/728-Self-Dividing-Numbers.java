class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for(int i=left;i<=right;i++) {
            int temp = i;
            boolean flag = true;
            while(temp>0) {
                int ld = temp % 10;
                if(ld==0|| i % ld != 0) {
                    flag = false;
                    break;
                }
                temp /= 10;
            }
            if(flag) res.add(i);
        }
        return res;
    }
}