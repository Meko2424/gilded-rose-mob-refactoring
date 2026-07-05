package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            normalItemQuality(item);
            conjuredItemQuality(item);
            passQuality(item);
            brieQuality(item);
        }
    }

    private void normalItemQuality(Item item) {
        if (!isBrie(item) && !isPasses(item) && !isSulfuras(item) && !isConjuredItem(item)) {
            decreaseQuality(item);
            item.sellIn--;
            if (item.sellIn < 0 && item.quality > 0) {
                decreaseQuality(item);
            }
        }
    }

    private void conjuredItemQuality(Item item) {
        if (isConjuredItem(item)) {
            decreaseQuality(item);
            decreaseQuality(item);
            item.sellIn--;
            if (item.sellIn < 0 && item.quality > 0) {
                decreaseQuality(item);
                decreaseQuality(item);
            }
        }
    }

    private void passQuality(Item item) {
        if(isPasses(item)) {
            increaseQuality(item);
            if (item.sellIn < 11) {
                increaseQuality(item);
            }
            if (item.sellIn < 6) {
                increaseQuality(item);
            }
            item.sellIn--;
            if(item.sellIn < 0) {
                item.quality = 0;
            }
        }
    }

    private void brieQuality(Item item) {
        if (isBrie(item)) {
            increaseQuality(item);
            item.sellIn--;
            if (item.sellIn < 0) {
                increaseQuality(item);
            }
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private boolean isPasses(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isConjuredItem(Item item) {
        return item.name.equals("Conjured Item");
    }
}
