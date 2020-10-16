package fighter

import equipment.Equipment

class Rouge(name: String) : BaseFighter(name) {
    override val stat = Stat(
            100.0, 150.0, 50.0,
            -0.2, 0.0, 0.2,
            7.0, 0.0, 3.0
    )
    override val equipment = Equipment(stat)
    //    Реализация фабричного метод
    override fun attack(): PoisonAttack {
        val damage: Double = (stat.stamina * stat.power + stat.mana * stat.willpower) * Math.random()
        this.stat.stamina -= damage * stat.power
        this.stat.mana -= damage * stat.willpower
        return PoisonAttack(damage)
    }
}