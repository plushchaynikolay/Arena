class Warrior(name: String) : BaseFighter(name) {
    override val maxHealth: Double = 200.0
    override val maxStamina: Double = 100.0
    override val maxMana: Double = 10.0

    override var health = maxHealth
    override var stamina = maxStamina
    override var mana = maxMana

    override fun attack(): Double {
        val damage: Double = stamina * 0.5 * Math.random()
        this.stamina -= damage
        return damage
    }
}