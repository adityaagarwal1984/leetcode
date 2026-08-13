class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> graph = new HashMap<>(); // ingredient -> list of recipes that need it
        Map<String, Integer> inDegree = new HashMap<>();   // recipe -> count of missing ingredients
        
        // 1. Build the dependency graph
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            List<String> ingList = ingredients.get(i);
            
            inDegree.put(recipe, ingList.size());
            
            for (String ing : ingList) {
                graph.putIfAbsent(ing, new ArrayList<>());
                graph.get(ing).add(recipe);
            }
        }
        
        // 2. Queue with initial supplies
        Queue<String> queue = new LinkedList<>();
        for (String s : supplies) {
            queue.offer(s);
        }
        
        List<String> ans = new ArrayList<>();
        
        // 3. Process BFS
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            
            // If curr is a recipe, add it to our answer!
            if (inDegree.containsKey(curr) && inDegree.get(curr) == 0) {
                ans.add(curr);
            }
            
            if (!graph.containsKey(curr)) continue;
            
            for (String dependentRecipe : graph.get(curr)) {
                inDegree.put(dependentRecipe, inDegree.get(dependentRecipe) - 1);
                
                // If all ingredients are now available
                if (inDegree.get(dependentRecipe) == 0) {
                    queue.offer(dependentRecipe);
                }
            }
        }
        
        return ans;
    }
}