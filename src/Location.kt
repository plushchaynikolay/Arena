import equipment.ItemFactory
import fighter.Fighter
import fighter.Mage
import fighter.Rouge
import fighter.Warrior

interface Location {
    val name: String
    fun hasEnemies(): Boolean
    fun getEnemy(): Fighter
}

// Абстрактная фабрика
abstract class BaseLocation(
        private val itemFactory: ItemFactory
) : Location {
    abstract val enemies: MutableList<Fighter>
    override fun hasEnemies(): Boolean = !enemies.isNullOrEmpty()
    override fun getEnemy(): Fighter = enemies.random().equip(itemFactory.get())
}

// Реальная фабрика
class BanditsDungeon(itemFactory: ItemFactory) : BaseLocation(itemFactory) {
    override val name: String = "Bandits dungeon"
    override val enemies: MutableList<Fighter> = mutableListOf(
            Warrior("Kirk"),
            Warrior("Bone"),
            Warrior("Gregor")
    )
}

// Реальная фабрика
class RougesForest(itemFactory: ItemFactory) : BaseLocation(itemFactory) {
    override val name: String = "Rouges forest"
    override val enemies: MutableList<Fighter> = mutableListOf(
            Rouge("Elestar"),
            Rouge("Whatar"),
            Rouge("Patric")
    )
}

// Реальная фабрика
class MagesTower(itemFactory: ItemFactory) : BaseLocation(itemFactory) {
    override val name: String = "Mages tower"
    override val enemies: MutableList<Fighter> = mutableListOf(
            Mage("Maldanazar"),
            Mage("Calebran"),
            Mage("Selefnir")
    )
}