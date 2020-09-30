interface Fighter {
    fun fight(enemy: Fighter)
    fun defend(damage: Double)
    fun printStats()
    fun isAlive(): Boolean
    fun getFighterName(): String
}