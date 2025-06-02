package com.gildedrose.behavior;

import com.gildedrose.Item;

public class ConjuredBehavior extends StandardBehavior {
    @Override
    public void update(Item item) {
        decreaseSellIn(item);
        int degradeRate = item.sellIn < 0 ? 4 : 2;
        decreaseQuality(item, degradeRate);
    }
}
