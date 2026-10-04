import java.util.*;

class Solution {
    public int minJumps(int[] arr) {

        int n = arr.length;
        if (n == 1) return 0;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        q.offer(0);
        vis[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int curr = q.poll();

                if (curr == n - 1)
                    return steps;

                // Right
                if (curr + 1 < n && !vis[curr + 1]) {
                    vis[curr + 1] = true;
                    q.offer(curr + 1);
                }

                // Left
                if (curr - 1 >= 0 && !vis[curr - 1]) {
                    vis[curr - 1] = true;
                    q.offer(curr - 1);
                }

                if (map.containsKey(arr[curr])) {
                    for (int next : map.get(arr[curr])) {
                        if (!vis[next]) {
                            vis[next] = true;
                            q.offer(next);
                        }
                    }
                    map.remove(arr[curr]);
                }
            }

            steps++;
        }

        return -1;
    }
}