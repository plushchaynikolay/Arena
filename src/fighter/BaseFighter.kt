package fighter

import equipment.Equipment
import equipment.Item
import format

abstract class BaseFighter(override val name: String) : Fighter {
    //    Фабричный метод
    abstract fun attack(): Attack
    abstract override val stat: Stat

    abstract override val equipment: Equipment
    override fun equip(item: Item?): BaseFighter {
        if (item != null)
            equipment.equipmentList.add(item)
        return this
    }

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
            println("$name deals ${format(attack.damage)} damage to ${enemy.name}")
            enemy.defend(attack)
        }
    }

    override fun defend(attack: Attack) {
        val damage: Double = attack.calculate(this)
        val reflectedDamage: Double = if (stat.protection < 1) damage * stat.protection else damage
        println("$name reflects damage $reflectedDamage out of $damage")
        this.stat.health = stat.health - (damage - reflectedDamage)
    }
}