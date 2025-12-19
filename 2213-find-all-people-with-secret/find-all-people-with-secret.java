class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);

        Set<Integer> know = new HashSet<>();
        know.add(0);
        know.add(firstPerson);

        int i = 0;
        while (i < meetings.length) {
            int time = meetings[i][2];

            // graph for same time
            Map<Integer, List<Integer>> graph = new HashMap<>();
            Set<Integer> people = new HashSet<>();

            while (i < meetings.length && meetings[i][2] == time) {
                int x = meetings[i][0], y = meetings[i][1];
                graph.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
                graph.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
                people.add(x);
                people.add(y);
                i++;
            }

            Queue<Integer> q = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();

            for (int p : people) {
                if (know.contains(p)) {
                    q.add(p);
                    visited.add(p);
                }
            }

            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int nei : graph.getOrDefault(cur, List.of())) {
                    if (visited.add(nei)) {
                        q.add(nei);
                    }
                }
            }

            know.addAll(visited);
        }

        return new ArrayList<>(know);
    }
}
