package com.gildedrose.behavior;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgedBrieBehaviorTest {

    private final AgedBrieBehavior behavior = new AgedBrieBehavior();

    @Test
    void qualityIncreasesByOneBeforeSellDate() {
        Item item = new Item("Aged Brie", 10, 40);
        behavior.update(item);
        assertEquals(41, item.quality);
    }

    @Test
    void qualityIncreasesByTwoAfterSellDate() {
        Item item = new Item("Aged Brie", 0, 40);
        behavior.update(item);
        assertEquals(42, item.quality);
    }

    @Test
    void qualityDoesNotExceedFifty() {
        Item item = new Item("Aged Brie", 5, 50);
        behavior.update(item);
        assertEquals(50, item.quality);
    }

    @Test
    void sellInDecreasesByOne() {
        Item item = new Item("Aged Brie", 5, 40);
        behavior.update(item);
        assertEquals(4, item.sellIn);
    }

    @Test
    void qualityIncreasesByTwoButDoesNotExceedFiftyAfterSellDate() {
        Item item = new Item("Aged Brie", 0, 49);
        behavior.update(item);
        assertEquals(50, item.quality);
    }
}
