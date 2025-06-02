package com.gildedrose.behavior;

import com.gildedrose.ItemType;
import com.gildedrose.TypedItem;

import java.util.EnumMap;
import java.util.Map;

public class ItemBehaviorResolver {
    private final Map<ItemType, ItemBehavior> behaviorMap = new EnumMap<>(ItemType.class);

    public ItemBehaviorResolver() {
        behaviorMap.put(ItemType.AGED_BRIE, new AgedBrieBehavior());
        behaviorMap.put(ItemType.BACKSTAGE_PASS, new BackstagePassBehavior());
        behaviorMap.put(ItemType.SULFURAS, new SulfurasBehavior());
        behaviorMap.put(ItemType.CONJURED, new ConjuredBehavior());
        behaviorMap.put(ItemType.STANDARD, new StandardBehavior()); // fallback
    }

    public ItemBehavior resolve(TypedItem typedItem) {
        return behaviorMap.getOrDefault(typedItem.getType(), new StandardBehavior());
    }
}
