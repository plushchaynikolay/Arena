abstract class BaseFighter(val name: String) : Fighter {
    protected abstract val maxHealth: Double
    protected abstract val maxStamina: Double
    protected abstract val maxMana: Double

    protected abstract var health: Double
    protected abstract var stamina: Double
    protected abstract var mana: Double

    override fun printStats() {
        println("${name}(HP:${health}/${maxHealth} SP:${stamina}/${maxStamina} MP:${mana}/${maxMana})")
    }

    override fun isAlive() = health > 0.0
    override fun getFighterName() = name

    override fun defend(damage: Double) {
        this.health = health - damage
    }

    override fun fight(enemy: Fighter) {
        if (isAlive() && stamina > 0) {
            val damage: Double = attack()
            println("${name} deals ${damage} damage to ${enemy.getFighterName()}")
            enemy.defend(damage)
        }
        rest()
    }

    abstract fun attack(): Double

    fun rest() {
        this.stamina = if (maxStamina - stamina > 15) stamina + 15 else maxStamina
        this.mana = if (maxMana - mana > 15) mana + 15 else maxMana
    }
}