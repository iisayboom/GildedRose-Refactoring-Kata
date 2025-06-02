package com.gildedrose.behavior;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackstagePassBehaviorTest {

    private final BackstagePassBehavior behavior = new BackstagePassBehavior();

    @Test
    void qualityIncreasesByOneWhenSellInGreaterThanTen() {
        Item item = new Item("Backstage passes", 15, 20);
        behavior.update(item);
        assertEquals(21, item.quality);
    }

    @Test
    void qualityIncreasesByTwoWhenSellInBetweenSixAndTen() {
        Item item = new Item("Backstage passes", 10, 20);
        behavior.update(item);
        assertEquals(22, item.quality);
    }

    @Test
    void qualityIncreasesByThreeWhenSellInFiveOrLess() {
        Item item = new Item("Backstage passes", 5, 20);
        behavior.update(item);
        assertEquals(23, item.quality);
    }

    @Test
    void qualityDropsToZeroAfterConcert() {
        Item item = new Item("Backstage passes", 0, 20);
        behavior.update(item);
        assertEquals(0, item.quality);
    }

    @Test
    void qualityDoesNotExceedFifty() {
        Item item = new Item("Backstage passes", 5, 49);
        behavior.update(item);
        assertEquals(50, item.quality);
    }

    @Test
    void sellInDecreasesByOne() {
        Item item = new Item("Backstage passes", 5, 20);
        behavior.update(item);
        assertEquals(4, item.sellIn);
    }
}
