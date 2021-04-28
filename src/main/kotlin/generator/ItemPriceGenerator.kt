package generator

import model.ItemPrice

object ItemPriceGenerator {
    fun getItems(): ArrayList<ItemPrice> {
        return arrayListOf<ItemPrice>().apply {
            add(ItemPrice("Xiomi Mi 11",9999000))
            add(ItemPrice("TV Xiomi Mi 4A",2100000))
            add(ItemPrice("Samsung S21",1800000))
            add(ItemPrice("Samsung A52",5500000))
            add(ItemPrice("Power Bank Anker 1000 mAh",300000))
        }
    }
}