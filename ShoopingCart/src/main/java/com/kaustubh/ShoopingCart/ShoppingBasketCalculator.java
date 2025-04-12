package com.kaustubh.ShoopingCart;

import java.util.*;

public class ShoppingBasketCalculator {

    // Prices in pence
    private static final int APPLE_PRICE = 35;
    private static final int BANANA_PRICE = 20;
    private static final int MELON_PRICE = 50;
    private static final int LIME_PRICE = 15;

    public static int calculateTotal(List<String> basket) {
        Map<String, Integer> itemCounts = new HashMap<String,Integer>();

        // Count items in the basket
        for (String item : basket) {
            itemCounts.put(item, itemCounts.getOrDefault(item, 0) + 1);
        }

        int total = 0;

        // Calculate cost for apples
        int appleCount = itemCounts.getOrDefault("Apple", 0);
        total += appleCount * APPLE_PRICE;

        // Calculate cost for bananas
        int bananaCount = itemCounts.getOrDefault("Banana", 0);
        total += bananaCount * BANANA_PRICE;

        // Calculate cost for melons (BOGOF)
        int melonCount = itemCounts.getOrDefault("Melon", 0);
        total += ((melonCount / 2) + (melonCount % 2)) * MELON_PRICE;

        // Calculate cost for limes (3 for 2)
        int limeCount = itemCounts.getOrDefault("Lime", 0);
        total += ((limeCount / 3) * 2 + (limeCount % 3)) * LIME_PRICE;

        return total;
    }

    public static void main(String[] args) {
        List<String> basket = Arrays.asList("Apple", "Apple", "Banana", "Melon", "Melon", "Melon", "Lime", "Lime", "Lime", "Lime");

        int total = calculateTotal(basket);
        System.out.printf("Total cost: %d pence (£%.2f)%n", total, total / 100.0);
    }
}

