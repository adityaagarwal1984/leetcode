class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // Base case: Already at destination
        if (source == target) return 0;

        // Step 1: Build mapping of Stop -> List of Bus Routes
        Map<Integer, List<Integer>> stopToRoutes = new HashMap<>();
        for (int routeId = 0; routeId < routes.length; routeId++) {
            for (int stop : routes[routeId]) {
                stopToRoutes.putIfAbsent(stop, new ArrayList<>());
                stopToRoutes.get(stop).add(routeId);
            }
        }

        // If source or target stops don't exist in any route
        if (!stopToRoutes.containsKey(source) || !stopToRoutes.containsKey(target)) {
            return -1;
        }

        // Step 2: Set up BFS
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedRoutes = new HashSet<>();
        Set<Integer> visitedStops = new HashSet<>();

        // Start BFS from all routes that pass through the source stop
        for (int routeId : stopToRoutes.get(source)) {
            queue.offer(routeId);
            visitedRoutes.add(routeId);
        }
        visitedStops.add(source);

        int busCount = 1;

        // Step 3: BFS level by level
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                int currRouteId = queue.poll();

                // Check all stops served by this current bus route
                for (int stop : routes[currRouteId]) {
                    // Target found!
                    if (stop == target) {
                        return busCount;
                    }

                    // If we haven't explored this stop yet, find new transfer routes
                    if (!visitedStops.contains(stop)) {
                        visitedStops.add(stop);

                        for (int nextRouteId : stopToRoutes.get(stop)) {
                            if (!visitedRoutes.contains(nextRouteId)) {
                                visitedRoutes.add(nextRouteId);
                                queue.offer(nextRouteId);
                            }
                        }
                    }
                }
            }
            busCount++;
        }

        return -1;
    }
}