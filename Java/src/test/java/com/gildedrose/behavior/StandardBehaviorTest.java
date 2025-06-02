package com.gildedrose.behavior;

import org.junit.jupiter.api.Test;
import com.gildedrose.Item;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StandardBehaviorTest {

    private final StandardBehavior behavior = new StandardBehavior();

    @Test
    void qualityDegradesByOneBeforeSellDate() {
        Item item = new Item("Standard Item", 10, 20);
        behavior.update(item);
        assertEquals(19, item.quality);
    }

    @Test
    void qualityDegradesByTwoAfterSellDate() {
        Item item = new Item("Standard Item", 0, 20);
        behavior.update(item);
        assertEquals(18, item.quality);
    }

    @Test
    void qualityDoesNotDropBelowZero() {
        Item item = new Item("Standard Item", 5, 0);
        behavior.update(item);
        assertEquals(0, item.quality);
    }

    @Test
    void qualityDegradesButStaysNonNegative() {
        Item item = new Item("Standard Item", -1, 1);
        behavior.update(item);
        assertEquals(0, item.quality);
    }

    @Test
    void sellInDecreasesByOne() {
        Item item = new Item("Standard Item", 5, 10);
        behavior.update(item);
        assertEquals(4, item.sellIn);
    }
}
