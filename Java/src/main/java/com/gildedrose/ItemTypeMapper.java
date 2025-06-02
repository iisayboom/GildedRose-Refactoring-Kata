package com.gildedrose;

public class ItemTypeMapper {
    public static TypedItem map(Item item) {
        String name = item.name.toLowerCase();

        if (name.contains("conjured")) return new TypedItem(item, ItemType.CONJURED);
        if (name.equals("aged brie")) return new TypedItem(item, ItemType.AGED_BRIE);
        if (name.startsWith("backstage passes")) return new TypedItem(item, ItemType.BACKSTAGE_PASS);
        if (name.equals("sulfuras, hand of ragnaros")) return new TypedItem(item, ItemType.SULFURAS);

        return new TypedItem(item, ItemType.STANDARD);
    }
}
