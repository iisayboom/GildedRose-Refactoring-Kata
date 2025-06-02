package com.gildedrose.behavior;

import com.gildedrose.Item;

public class StandardBehavior implements ItemBehavior {
    @Override
    public void update(Item item) {
        decreaseSellIn(item);

        int degradeRate = item.sellIn < 0 ? 2 : 1;
        decreaseQuality(item, degradeRate);
    }

    protected void decreaseSellIn(Item item) {
        item.sellIn--;
    }

    protected void decreaseQuality(Item item, int amount) {
        item.quality = Math.max(0, item.quality - amount);
    }
}
