abstract class BaseFighter(override val name: String) : Fighter {
    abstract fun attack(): Attack
    abstract override val stat: Stat

    override fun toString() = "$name ($stat)"
    override fun isAlive() = stat.health > 0.0

    //    Делегирование
    override fun rest() = stat.rest()
    override fun reset() = stat.reset()

    //    Шаблонный метод
    override fun fight(enemy: Fighter) {
        if (isAlive() && stat.stamina > 0) {
            //  Вызовы виртуальных методов
            val attack: Attack = attack()
            enemy.defend(attack)
            println("$name deals ${format(attack.damage)} damage to ${enemy.name}")
        }
    }

    override fun defend(attack: Attack) {
        this.stat.health = stat.health - attack.calculate(this)
    }
}