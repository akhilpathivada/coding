/**
 * author: akhilpathivada
 * time: 21/05/24 09:12
 *
 * https://leetcode.com/problems/design-a-food-rating-system/description/
 *
 */
package design;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FoodRatings {

    private final class FoodItem implements Comparable<FoodItem> {

        private final String name;

        private final String cuisine;

        private int rating;

        private FoodItem(String name, String cuisine, int rating) {
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }

        @Override
        public int compareTo(FoodItem foodItem) {
            if (this.rating == foodItem.rating) {
                return this.name.compareTo(foodItem.name);
            }
            return Integer.compare(foodItem.rating, this.rating);
        }
    }

    private final String[] foods;

    private final String[] cuisines;

    private final int[] ratings;

    private final Map<String, FoodItem> foodMap;

    private final Map<String, PriorityQueue<FoodItem>> cuisineToFoodItemsMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.foods = foods;
        this.cuisines = cuisines;
        this.ratings = ratings;
        this.foodMap = new HashMap<>();
        this.cuisineToFoodItemsMap = new HashMap<>();
        // insert the data
        for (int i = 0; i < foods.length; ++i) {
            FoodItem foodItem = new FoodItem(foods[i], cuisines[i], ratings[i]);
            cuisineToFoodItemsMap.computeIfAbsent(cuisines[i], p -> new PriorityQueue<>()).offer(foodItem);
            foodMap.put(foodItem.name, foodItem);
        }
    }

    public void changeRating(String food, int newRating) {
        FoodItem foodItem = foodMap.get(food);
        String cuisine = foodItem.cuisine;
        PriorityQueue<FoodItem> foodItems = cuisineToFoodItemsMap.get(cuisine);
        foodItems.remove(foodItem); // in java, we can remove a specific item from queue
        foodItem.rating = newRating;
        foodItems.offer(foodItem);
        foodMap.put(food, foodItem);
    }

    public String highestRated(String cuisine) {
        // we can add expection handling - but not required for this question :D
        return cuisineToFoodItemsMap.get(cuisine).peek().name;
    }

    public static void main(String[] args) {
        FoodRatings foodRatings = new FoodRatings(new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
                new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"},
                new int[]{9, 12, 8, 15, 14, 7});
        System.out.println(foodRatings.highestRated("korean")); // return "kimchi"
        // "kimchi" is the highest rated korean food with a rating of 9.
        System.out.println(foodRatings.highestRated("japanese")); // return "ramen"
        // "ramen" is the highest rated japanese food with a rating of 14.
        foodRatings.changeRating("sushi", 16); // "sushi" now has a rating of 16.
        System.out.println(foodRatings.highestRated("japanese")); // return "sushi"
        // "sushi" is the highest rated japanese food with a rating of 16.
        foodRatings.changeRating("ramen", 16); // "ramen" now has a rating of 16.
        System.out.println(foodRatings.highestRated("japanese")); // return "ramen"
        // Both "sushi" and "ramen" have a rating of 16.
        // However, "ramen" is lexicographically smaller than "sushi".
    }
}
