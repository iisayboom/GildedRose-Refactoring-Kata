package com.gildedrose.behavior;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SulfurasBehaviorTest {

    private final SulfurasBehavior behavior = new SulfurasBehavior();

    @Test
    void qualityAndSellInRemainUnchanged() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        behavior.update(item);
        assertEquals(0, item.sellIn);
        assertEquals(80, item.quality);
    }
}
