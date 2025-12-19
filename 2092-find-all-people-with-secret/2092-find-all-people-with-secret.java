class Solution {
    int[] parent;

    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int x, int y) {
        parent[find(y)] = find(x);
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        Set<Integer> secret = new HashSet<>();
        secret.add(0);
        secret.add(firstPerson);

        int i = 0;
        while (i < meetings.length) {
            int time = meetings[i][2];
            List<int[]> batch = new ArrayList<>();

            while (i < meetings.length && meetings[i][2] == time) {
                union(meetings[i][0], meetings[i][1]);
                batch.add(meetings[i]);
                i++;
            }

            Map<Integer, List<Integer>> groups = new HashMap<>();
            for (int[] m : batch) {
                groups.computeIfAbsent(find(m[0]), k -> new ArrayList<>()).add(m[0]);
                groups.get(find(m[0])).add(m[1]);
            }

            for (List<Integer> group : groups.values()) {
                for (int p : group) {
                    if (secret.contains(p)) {
                        secret.addAll(group);
                        break;
                    }
                }
            }

            for (int[] m : batch) {
                parent[m[0]] = m[0];
                parent[m[1]] = m[1];
            }
        }
        return new ArrayList<>(secret);
    }
}
