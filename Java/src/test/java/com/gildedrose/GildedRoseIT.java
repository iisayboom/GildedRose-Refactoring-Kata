package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseIT {

    @Test
    void updatesAllItemTypesCorrectly() {
        List<Item> items = List.of(
            new Item("Aged Brie", 2, 0),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Conjured Mana Cake", 3, 6),
            new Item("Elixir of the Mongoose", 5, 7)
        );

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        agedBrieIncreasesQuality(items);
        backstagePassesIncreaseQualityByOne(items);
        sulfurasRemainsUnchanged(items);
        conjuredDegradesByTwo(items);
        standardItemDegradesByOne(items);
    }

    private void standardItemDegradesByOne(List<Item> items) {
        assertEquals(6, items.get(4).quality);
        assertEquals(4, items.get(4).sellIn);
    }

    private void conjuredDegradesByTwo(List<Item> items) {
        assertEquals(4, items.get(3).quality);
        assertEquals(2, items.get(3).sellIn);
    }

    private void sulfurasRemainsUnchanged(List<Item> items) {
        assertEquals(80, items.get(2).quality);
        assertEquals(0, items.get(2).sellIn);
    }

    private void backstagePassesIncreaseQualityByOne(List<Item> items) {
        assertEquals(21, items.get(1).quality);
        assertEquals(14, items.get(1).sellIn);
    }

    private void agedBrieIncreasesQuality(List<Item> items) {
        assertEquals(1, items.getFirst().quality);
        assertEquals(1, items.getFirst().sellIn);
    }
}
