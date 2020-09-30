class Rouge(name: String) : BaseFighter(name) {
    override val maxHealth: Double = 100.0
    override val maxStamina: Double = 150.0
    override val maxMana: Double = 10.0

    override var health = maxHealth
    override var stamina = maxStamina
    override var mana = maxMana

    override fun attack(): Double {
        val damage: Double = stamina * Math.random()
        this.stamina -= damage
        return damage
    }
}