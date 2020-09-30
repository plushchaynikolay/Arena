class Mage(name: String) : BaseFighter(name) {
    override val maxHealth: Double = 50.0
    override val maxStamina: Double = 10.0
    override val maxMana: Double = 150.0

    override var health = maxHealth
    override var stamina = maxStamina
    override var mana = maxMana

    override fun attack(): Double {
        val damage: Double = mana * 0.7 * Math.random()
        this.mana -= damage
        return damage
    }

    override fun defend(damage: Double) {
        super.defend(damage)
        if (isAlive() && health < damage) {
            heal()
        }
    }

    fun heal() {
        val healAmount: Double = if (mana > 15.0) 15.0 else mana
        this.health = if (health + healAmount < maxHealth) healAmount else maxHealth
        this.mana -= healAmount
        println("${name} heals self with ${healAmount} HP")
    }
}