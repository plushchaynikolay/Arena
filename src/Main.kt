import equipment.Item
import equipment.ItemFactory
import fighter.Fighter
import fighter.Mage
import fighter.Rouge
import fighter.Warrior

fun main() {
    var option: String? = null
    while (option == null) {
        print("Enter fighter's name: ")
        option = readLine()
    }

    val name: String = option
    val hero: Fighter

    while (true) {
        print("Choose fighter's class (w, r, m): ")
        hero = when (readLine()) {
            "w" -> Warrior(name)
            "r" -> Rouge(name)
            "m" -> Mage(name)
            else -> continue
        }
        break
    }
    val itemFactory = ItemFactory()
    hero.equip(itemFactory.get())
    val locations: List<Location> = listOf(
            BanditsDungeon(itemFactory),
            RougesForest(itemFactory),
            MagesTower(itemFactory)
    )
    var currentLocation: Location
    while (hero.isAlive() && locations.isNotEmpty()) {
        currentLocation = chooseLocation(locations.filter { location -> location.hasEnemies() })
        visit(hero, currentLocation)
    }
    println("Game over")
}

fun chooseLocation(locations: List<Location>): Location {
    var option: Int?
    do {
        println("Choose location:")
        locations.forEachIndexed { index, location -> println("${index + 1}) ${location.name}") }
        option = readLine().orEmpty().toIntOrNull()
        if (option != null && option > 0 && option < locations.size) return locations[option - 1]
        println()
    } while (true)
}

fun visit(hero: Fighter, location: Location) {
    println("${hero.name} steps into ${location.name}")
    val enemy: Fighter = location.getEnemy()

    if (hero.equipment.equipmentList.isNotEmpty())
        println("${hero.name}`s equipment:\n${hero.equipment}")
    if (enemy.equipment.equipmentList.isNotEmpty())
        println("${enemy.name}`s equipment:\n${enemy.equipment}")

    while (hero.isAlive() && enemy.isAlive()) {
        println(hero)
        println(enemy)
        //  Полиморфные вызовы
        hero.fight(enemy)
        enemy.fight(hero)
        hero.rest()
        hero.rest()
        readLine()
    }
    val winner: Fighter = if (hero.isAlive()) hero else enemy
    println("${winner.name} is a Winner!")

    if (hero == winner && enemy.equipment.equipmentList.isNotEmpty()) {
        println("${hero.name} loots:")
        println(enemy.equipment.toString())
        enemy.equipment.equipmentList.forEach { item: Item -> hero.equip(item) }
    }
}