package com.gildedrose;

public class TypedItem {
    private final Item item;
    private final ItemType type;

    public TypedItem(Item item, ItemType type) {
        this.item = item;
        this.type = type;
    }

    public Item getItem() {
        return item;
    }

    public ItemType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "TypedItem{" +
                "item=" + item +
                ", type=" + type +
                '}';
    }
}
