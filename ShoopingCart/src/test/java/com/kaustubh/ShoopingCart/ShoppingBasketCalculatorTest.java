package com.kaustubh.ShoopingCart;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShoppingBasketCalculatorTest {

    @Test
    public void testEmptyBasket() {
        List<String> basket = Collections.emptyList();
        assertEquals(0, ShoppingBasketCalculator.calculateTotal(basket));
    }

    @Test
    public void testSingleApple() {
        List<String> basket = Arrays.asList("Apple");
        assertEquals(35, ShoppingBasketCalculator.calculateTotal(basket));
    }

    @Test
    public void testMultipleApples() {
        List<String> basket = Arrays.asList("Apple", "Apple", "Apple");
        assertEquals(105, ShoppingBasketCalculator.calculateTotal(basket));
    }

    @Test
    public void testSingleBanana() {
        List<String> basket = Arrays.asList("Banana");
        assertEquals(20, ShoppingBasketCalculator.calculateTotal(basket));
    }

    @Test
    public void testMelonBOGOF_OneMelon() {
        List<String> basket = Arrays.asList("Melon");
        assertEquals(50, ShoppingBasketCalculator.calculateTotal(basket));
    }

    @Test
    public void testMelonBOGOF_TwoMelons() {
        List<String> basket = Arrays.asList("Melon", "Melon");
        assertEquals(50, ShoppingBasketCalculator.calculateTotal(basket));
    }

    @Test
    public void testMelonBOGOF_ThreeMelons() {
        List<String> basket = Arrays.asList("Melon", "Melon", "Melon");
        assertEquals(100, ShoppingBasketCalculator.calculateTotal(basket));
    }

    @Test
    public void testLimeThreeForTwo_ThreeLimes() {
        List<String> basket = Arrays.asList("Lime", "Lime", "Lime");
        assertEquals(30, ShoppingBasketCalculator.calculateTotal(basket));
    }

    @Test
    public void testLimeThreeForTwo_FourLimes() {
        List<String> basket = Arrays.asList("Lime", "Lime", "Lime", "Lime");
        assertEquals(45, ShoppingBasketCalculator.calculateTotal(basket));
    }

    @Test
    public void testMixedBasket() {
        List<String> basket = Arrays.asList(
                "Apple", "Apple",           // 2 * 35 = 70
                "Banana",                   // 1 * 20 = 20
                "Melon", "Melon",           // BOGOF = 50
                "Lime", "Lime", "Lime", "Lime"  // 3 for 2 + 1 = 45
        );
        int expected = 70 + 20 + 50 + 45;
        assertEquals(expected, ShoppingBasketCalculator.calculateTotal(basket));
    }
}
