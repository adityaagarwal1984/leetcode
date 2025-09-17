import java.util.*;

class FoodRatings {
    // Maps food -> cuisine
    private HashMap<String, String> foodToCuisine;
    // Maps food -> rating
    private HashMap<String, Integer> foodToRating;
    // Maps cuisine -> sorted set of foods
    private HashMap<String, TreeSet<String>> cuisineToFoods;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineToFoods = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodToCuisine.put(food, cuisine);
            foodToRating.put(food, rating);

            cuisineToFoods.putIfAbsent(cuisine, new TreeSet<>(
                (a, b) -> {
                    int cmp = Integer.compare(foodToRating.get(b), foodToRating.get(a));
                    if (cmp == 0) return a.compareTo(b);
                    return cmp;
                }
            ));
            cuisineToFoods.get(cuisine).add(food);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        TreeSet<String> set = cuisineToFoods.get(cuisine);

        // remove old entry
        set.remove(food);
        foodToRating.put(food, newRating);
        // re-insert with new rating
        set.add(food);
    }

    public String highestRated(String cuisine) {
        return cuisineToFoods.get(cuisine).first(); // top element
    }
}
