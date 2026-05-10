class Solution {
    private Map<Integer, List<Integer>> map = new HashMap<>();
    private Set<Integer> visit = new HashSet<>();
    public int countComponents(int n, int[][] edges) {
        if (n == 1)
            return 1;
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        int components = 0;

        for (int i = 0; i < n; i++) {
            if (!visit.contains(i)) {
                components++;
                dfs(i);
            }
        }
        return components;
    }

    private void dfs(int node) {
        if (visit.contains(node))
            return;
        visit.add(node);

        for (int i : map.get(node)) {
            dfs(i);
        }
        return;
    }
}
