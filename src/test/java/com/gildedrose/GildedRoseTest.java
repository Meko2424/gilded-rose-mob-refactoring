package com.gildedrose;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    @Test
    void normalItemDecreasesSellInAndQualityByOne(){
        Item [] items =  new Item[] {new Item("Normal Item", 10, 20)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(9, items[0].sellIn);
        assertEquals(19, items[0].quality);
    }

    @Test
    void normalItemQualityDecreasesTwiceAsFastAfterSellingDate(){
        Item [] items =  new Item[] {new Item("Normal Item", 0, 20)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(-1, items[0].sellIn);
        assertEquals(18, items[0].quality);
    }

    @Test
    void qualityIsNeverNegative() {
        Item [] items =  new Item[] {new Item("Normal Item", 0, 0)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertTrue(items[0].quality >= 0);
    }

    @Test
    void agedBrieQualityIncreasesWhenSellInDecreases() {
        final int initialQuality = 5;
        final int initialSellIn = 5;

        Item [] items =  new Item[] {new Item("Aged Brie", initialSellIn, initialQuality)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertTrue(items[0].sellIn < initialSellIn);
        assertTrue(items[0].quality > initialQuality);


    }

    @Test
      void agedBrieQualityCapsAt50(){
        Item [] items =  new Item[] {new Item("Aged Brie", 5, 50)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(4, items[0].sellIn);
        assertEquals(50, items[0].quality);
      }

    @Test
    void backstagePassIncreasesByOneWhenSellInGreaterThanTen(){
        Item [] items =  new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(14, items[0].sellIn);
        assertEquals(21, items[0].quality);
    }

    @Test
    void backstagePassIncreasesByTwoWhenSellInTenOrLess(){
        Item [] items =  new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(9, items[0].sellIn);
        assertEquals(22, items[0].quality);
    }

    @Test
    void backstagePassIncreasesByThreeWhenSellInFiveOrLess(){
        Item [] items =  new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(4, items[0].sellIn);
        assertEquals(23, items[0].quality);
    }

    @Test
    void backstagePassDecreasesToZeroAfterSellInPassesZero(){
        Item [] items =  new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void sulfurasNeverChanges(){
        Item [] items =  new Item[] {new Item("Sulfuras, Hand of Ragnaros", 10, 80)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(10, items[0].sellIn);
        assertEquals(80, items[0].quality);
    }

    @Test
    void conjuredItemsDegradeTwiceAsFastAsNormalItems(){
        Item [] items =  new Item[] {new Item("Conjured Item", 10, 20)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(9, items[0].sellIn);
        assertEquals(18, items[0].quality);
    }

    @Test
    void conjuredItemsDegradeByFourAfterSellInPasses(){
        Item [] items =  new Item[] {new Item("Conjured Item", 0, 20)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(-1, items[0].sellIn);
        assertEquals(16, items[0].quality);
    }
}
