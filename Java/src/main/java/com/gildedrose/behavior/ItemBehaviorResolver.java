package com.gildedrose.behavior;

import com.gildedrose.Item;

import java.util.HashMap;
import java.util.Map;

public class ItemBehaviorResolver {
    private static final Map<String, ItemBehavior> behaviorMap = new HashMap<>();
    private static final ItemBehavior defaultBehavior = new StandardBehavior();

    static {
        behaviorMap.put("Aged Brie", new AgedBrieBehavior());
        behaviorMap.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassBehavior());
        behaviorMap.put("Sulfuras, Hand of Ragnaros", new SulfurasBehavior());
    }

    public ItemBehavior resolve(Item item) {
        if (item.name != null && item.name.toLowerCase().contains("conjured")) {
            return new ConjuredBehavior();
        }
        return behaviorMap.getOrDefault(item.name, defaultBehavior);
    }
}
