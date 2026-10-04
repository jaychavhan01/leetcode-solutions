class Solution {
    public String getPermutation(int n, int k) {
        int fact=1;
        List<Integer> nums = new ArrayList<>();

        for(int i=1;i<n;i++) {
            fact = fact*i;
            nums.add(i);
        }
        nums.add(n);
        StringBuilder ans = new StringBuilder();

        k=k-1;
        while(true) {
            int ind = k/fact;
            ans.append(nums.get(ind));
            nums.remove(ind);
            if(nums.isEmpty()) break;
            k=k%fact;
            fact /= nums.size();
        }
        return ans.toString();
    }
}