/**
 * author: akhilpathivada
 * time: 21/05/24 19:29
 *
 * https://leetcode.com/problems/stock-price-fluctuation/description/
 *
 */
package design;

import java.util.TreeMap;

public class StockPriceFluctuation {

    private final TreeMap<Integer, Integer> timestampToPriceMap;

    private final TreeMap<Integer, Integer> priceFrequencyMap;

    public StockPriceFluctuation() {
        this.timestampToPriceMap = new TreeMap<>();
        this.priceFrequencyMap = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        if (timestampToPriceMap.containsKey(timestamp)) {
            int key = timestampToPriceMap.get(timestamp);
            priceFrequencyMap.put(key, priceFrequencyMap.get(key) - 1);
            if (priceFrequencyMap.get(key) == 0) {
                priceFrequencyMap.remove(key);
            }
        }
        timestampToPriceMap.put(timestamp, price);
        priceFrequencyMap.put(price, priceFrequencyMap.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return timestampToPriceMap.lastEntry().getValue();
    }

    public int maximum() {
        return priceFrequencyMap.lastKey();
    }

    public int minimum() {
        return priceFrequencyMap.firstKey();
    }

    public static void main(String[] args) {
        StockPriceFluctuation stockPrice = new StockPriceFluctuation();
        stockPrice.update(1, 10); // Timestamps are [1] with corresponding prices [10].
        stockPrice.update(2, 5);  // Timestamps are [1,2] with corresponding prices [10,5].
        System.out.println(stockPrice.current());     // return 5, the latest timestamp is 2 with the price being 5.
        System.out.println(stockPrice.maximum());     // return 10, the maximum price is 10 at timestamp 1.
        stockPrice.update(1, 3);  // The previous timestamp 1 had the wrong price, so it is updated to 3.
        // Timestamps are [1,2] with corresponding prices [3,5].
        System.out.println(stockPrice.maximum());     // return 5, the maximum price is 5 after the correction.
        stockPrice.update(4, 2);  // Timestamps are [1,2,4] with corresponding prices [3,5,2].
        System.out.println(stockPrice.minimum());     // return 2, the minimum price is 2 at timestamp 4.
    }
}
