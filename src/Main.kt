fun main() {
    var option: String? = null
    while (option == null) {
        print("Enter fighter's name: ")
        option = readLine()
    }

    val name: String = option
    val fighter1: Fighter

    while (true) {
        print("Choose fighter's class (w, r, m): ")
        fighter1 = when (readLine()) {
            "w" -> Warrior(name)
            "r" -> Rouge(name)
            "m" -> Mage(name)
            else -> continue
        }
        break
    }

    val fighter2: Fighter = listOf(
            Warrior("Gregor"),
            Rouge("Patric"),
            Mage("Shone")
    ).random()

    while (fighter1.isAlive() && fighter2.isAlive()) {
        println(fighter1)
        println(fighter2)
        //  Полиморфные вызовы
        fighter1.fight(fighter2)
        fighter2.fight(fighter1)
        fighter1.rest()
        fighter2.rest()
        readLine()
    }
    val winner: Fighter = if (fighter1.isAlive()) fighter1 else fighter2
    println("${winner.name} is a Winner!")
}