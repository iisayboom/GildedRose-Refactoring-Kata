package com.gildedrose.behavior;

import com.gildedrose.Item;

public class AgedBrieBehavior implements ItemBehavior {
    @Override
    public void update(Item item) {
        item.sellIn--;

        int increaseRate = item.sellIn < 0 ? 2 : 1;
        item.quality = Math.min(50, item.quality + increaseRate);
    }
}
