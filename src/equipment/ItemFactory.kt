package equipment

//  Фабрика
class ItemFactory {
    private val itemList: MutableList<Item> = mutableListOf(
            Item("Hammer", 0.0, 0.0, 0.0, 0.2, 0.0, 0.0),
            Item("Iron Armor", 0.0, 0.0, 0.0, 0.0, 0.2, 0.0),
            Item("Spell Book", 0.0, 0.0, 0.0, 0.0, 0.0, 0.2),
            Item("Spider Skin", 0.0, 0.0, 0.0, 0.0, 0.0, 0.2),
            Item("Wooden Shield", 0.0, 0.0, 0.0, 0.0, 0.0, 0.2),
            Item("Magic Mirror", 0.0, 0.0, 0.0, 0.0, 0.0, 0.2)
    )

//    фабричный метод
    fun get(): Item? {
        val item = itemList.randomOrNull()
        if (item != null)
            itemList.remove(item)
        return item
    }
}