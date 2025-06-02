package com.gildedrose;

import com.gildedrose.behavior.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class ItemBehaviorResolverTest {

    private final ItemBehaviorResolver resolver = new ItemBehaviorResolver();

    @Test
    void resolvesAgedBrieBehavior() {
        TypedItem typedItem = new TypedItem(new Item("Aged Brie", 10, 20), ItemType.AGED_BRIE);
        ItemBehavior behavior = resolver.resolve(typedItem);
        assertInstanceOf(AgedBrieBehavior.class, behavior);
    }

    @Test
    void resolvesBackstagePassBehavior() {
        TypedItem typedItem = new TypedItem(new Item("Backstage passes", 5, 30), ItemType.BACKSTAGE_PASS);
        ItemBehavior behavior = resolver.resolve(typedItem);
        assertInstanceOf(BackstagePassBehavior.class, behavior);
    }

    @Test
    void resolvesSulfurasBehavior() {
        TypedItem typedItem = new TypedItem(new Item("Sulfuras", 0, 80), ItemType.SULFURAS);
        ItemBehavior behavior = resolver.resolve(typedItem);
        assertInstanceOf(SulfurasBehavior.class, behavior);
    }

    @Test
    void resolvesConjuredBehavior() {
        TypedItem typedItem = new TypedItem(new Item("Conjured Mana Cake", 3, 6), ItemType.CONJURED);
        ItemBehavior behavior = resolver.resolve(typedItem);
        assertInstanceOf(ConjuredBehavior.class, behavior);
    }

    @Test
    void resolvesStandardBehavior() {
        TypedItem typedItem = new TypedItem(new Item("Elixir of the Mongoose", 5, 7), ItemType.STANDARD);
        ItemBehavior behavior = resolver.resolve(typedItem);
        assertInstanceOf(StandardBehavior.class, behavior);
    }

    @Test
    void fallbackToStandardBehaviorOnNullType() {
        TypedItem typedItem = new TypedItem(new Item("Unknown Item", 5, 7), null);
        ItemBehavior behavior = resolver.resolve(typedItem);
        assertInstanceOf(StandardBehavior.class, behavior);
    }
}
