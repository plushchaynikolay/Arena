package fighter

class Mage(name: String) : BaseFighter(name) {
    override val stat = Stat(
            50.0, 10.0, 150.0,
            0.2, -0.2, 0.0,
            0.0, 0.0, 0.7
    )

    override fun attack(): MagicAttack {
        val damage: Double = stat.mana * stat.willpower * Math.random()
        this.stat.mana -= damage
        return MagicAttack(damage)
    }

    override fun defend(attack: Attack) {
        super.defend(attack)
        if (isAlive() && stat.health < attack.damage)
            heal()
    }

    private fun heal() {
        val healAmount: Double = if (stat.mana > 15.0) 15.0 else stat.mana
        this.stat.health += healAmount * (1.0 + stat.willpower)
        this.stat.mana -= healAmount
        println("$name heals self with $healAmount HP")
    }
}