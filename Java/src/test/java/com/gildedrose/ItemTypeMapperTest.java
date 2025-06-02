package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTypeMapperTest {

    @Test
    void mapsAgedBrieCorrectly() {
        Item item = new Item("Aged Brie", 10, 20);
        TypedItem typedItem = ItemTypeMapper.map(item);
        assertEquals(ItemType.AGED_BRIE, typedItem.getType());
    }

    @Test
    void mapsBackstagePassCorrectly() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 30);
        TypedItem typedItem = ItemTypeMapper.map(item);
        assertEquals(ItemType.BACKSTAGE_PASS, typedItem.getType());
    }

    @Test
    void mapsSulfurasCorrectly() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        TypedItem typedItem = ItemTypeMapper.map(item);
        assertEquals(ItemType.SULFURAS, typedItem.getType());
    }

    @Test
    void mapsConjuredCorrectly() {
        Item item = new Item("Conjured Mana Cake", 3, 6);
        TypedItem typedItem = ItemTypeMapper.map(item);
        assertEquals(ItemType.CONJURED, typedItem.getType());
    }

    @Test
    void mapsUnknownToStandard() {
        Item item = new Item("Elixir of the Mongoose", 5, 7);
        TypedItem typedItem = ItemTypeMapper.map(item);
        assertEquals(ItemType.STANDARD, typedItem.getType());
    }

    @Test
    void mappingIsCaseInsensitive() {
        Item item = new Item("aGeD bRiE", 5, 10);
        TypedItem typedItem = ItemTypeMapper.map(item);
        assertEquals(ItemType.AGED_BRIE, typedItem.getType());
    }
}
