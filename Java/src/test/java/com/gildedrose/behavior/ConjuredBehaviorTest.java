package com.gildedrose.behavior;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConjuredBehaviorTest {

    private final ConjuredBehavior behavior = new ConjuredBehavior();

    @Test
    void qualityDecreasesByTwoBeforeSellDate() {
        Item item = new Item("Conjured Mana Cake", 5, 20);
        behavior.update(item);
        assertEquals(18, item.quality);
    }

    @Test
    void qualityDecreasesByFourAfterSellDate() {
        Item item = new Item("Conjured Mana Cake", 0, 20);
        behavior.update(item);
        assertEquals(16, item.quality);
    }

    @Test
    void qualityNeverNegative() {
        Item item = new Item("Conjured Mana Cake", 0, 3);
        behavior.update(item);
        assertEquals(0, item.quality);
    }

    @Test
    void sellInDecreasesByOne() {
        Item item = new Item("Conjured Mana Cake", 1, 10);
        behavior.update(item);
        assertEquals(0, item.sellIn);
    }

    @Test
    void qualityRemainsZeroBeforeSellDateIfAlreadyZero() {
        Item item = new Item("Conjured Mana Cake", 5, 0);
        behavior.update(item);
        assertEquals(0, item.quality);
    }

    @Test
    void qualityRemainsZeroAfterSellDateIfAlreadyZero() {
        Item item = new Item("Conjured Mana Cake", -1, 0);
        behavior.update(item);
        assertEquals(0, item.quality);
    }
}
