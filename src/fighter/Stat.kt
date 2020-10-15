package fighter

import format

interface IStat {
    val poisonResist: Double
    val physicResist: Double
    val manaResist: Double
    val power: Double
    val protection: Double
    val willpower: Double
}

open class Stat(
        private val maxHealth: Double,
        private val maxStamina: Double,
        private val maxMana: Double,
        override val poisonResist: Double,
        override val physicResist: Double,
        override val manaResist: Double,
        override val power: Double,
        override val protection: Double,
        override val willpower: Double
) : IStat {
    var health: Double = maxHealth
        set(value) {
            field = if (value < maxHealth) value else maxHealth
        }
    var stamina: Double = maxStamina
    var mana: Double = maxMana

    fun rest() {
        this.stamina = if (maxStamina - stamina > 15) stamina + 15 else maxStamina
        this.mana = if (maxMana - mana > 15) mana + 15 else maxMana
    }

    fun reset() {
        this.health = maxHealth
        this.stamina = maxStamina
        this.mana = maxMana
    }

    override fun toString() = ("(HP:${format(health)}/$maxHealth "
            + "SP:${format(stamina)}/$maxStamina "
            + "MP:${format(mana)}/$maxMana)")
}