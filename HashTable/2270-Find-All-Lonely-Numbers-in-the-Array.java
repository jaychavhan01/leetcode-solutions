class Solution {
    public List<Integer> findLonely(int[] nums) {
        ArrayList<Integer> al = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val:nums) {
            if(map.containsKey(val)) {
                int freq = map.get(val);
                map.put(val,++freq);
            }
            else {
                map.put(val,1);
            }
        }
        for(int val:map.keySet()) {
            if(!map.containsKey(val-1) && !map.containsKey(val+1) && map.get(val)==1) {
                al.add(val);
            }
        }
        return al;
    }
}