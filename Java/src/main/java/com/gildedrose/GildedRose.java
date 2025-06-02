package com.gildedrose;

import com.gildedrose.behavior.ItemBehavior;
import com.gildedrose.behavior.ItemBehaviorResolver;

import java.util.Arrays;
import java.util.List;

class GildedRose {
    private final List<Item> items;
    private final ItemBehaviorResolver resolver = new ItemBehaviorResolver();

    public GildedRose(Item[] items) {
        this.items = Arrays.asList(items);
    }

    public void updateQuality() {
        for (Item item : items) {
            TypedItem typedItem = ItemTypeMapper.map(item);
            ItemBehavior behavior = resolver.resolve(typedItem);
            behavior.update(item);
        }
    }
}
