package fighter

interface Fighter {
    val name: String
    val stat: Stat
    fun fight(enemy: Fighter)
    fun defend(attack: Attack)
    fun isAlive(): Boolean
    fun rest()
    fun reset()
}