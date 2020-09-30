fun main() {
    val name: String
    var line: String?
    while (true) {
        print("Enter fighter's name: ")
        line = readLine()
        if (line != null) {
            name = line
            break
        }
    }
    val fighter1: Fighter
    var option: Fighter?
    while (true) {
        print("Choose fighter's class (w, r, m): ")
        option = when (readLine()) {
            "w" -> Warrior(name)
            "r" -> Rouge(name)
            "m" -> Mage(name)
            else -> null
        }
        if (option != null) {
            fighter1 = option
            break
        }
    }

    val fighter2: Fighter = listOf(
            Warrior("Gregor"),
            Rouge("Patric"),
            Mage("Shone")
    ).random()

    while (fighter1.isAlive() && fighter2.isAlive()) {
        fighter1.printStats()
        fighter2.printStats()
        fighter1.fight(fighter2)
        fighter2.fight(fighter1)
        readLine()
    }
    val winner: Fighter = if (fighter1.isAlive()) fighter1 else fighter2
    println("${winner.getFighterName()} is a Winner!")
}