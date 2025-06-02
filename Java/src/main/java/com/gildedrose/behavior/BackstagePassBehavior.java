package com.gildedrose.behavior;

import com.gildedrose.Item;

public class BackstagePassBehavior implements ItemBehavior {

    private static final int MAX_QUALITY = 50;

    @Override
    public void update(Item item) {
        item.sellIn--;

        if (item.sellIn < 0) {
            item.quality = 0;
            return;
        }

        item.quality += getQualityIncrease(item.sellIn);
        if (item.quality > MAX_QUALITY) {
            item.quality = MAX_QUALITY;
        }
    }

    private int getQualityIncrease(int sellIn) {
        if (sellIn < 5)
            return 3;
        if (sellIn < 10)
            return 2;

        return 1;
    }
}
