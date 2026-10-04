import java.util.*;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++) {

            char[] ele = strs[i].toCharArray();

            Arrays.sort(ele);

            String key = new String(ele);

            // if key not present create new list
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // add original string
            map.get(key).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }
}