package fighter

import equipment.Equipment
import equipment.Item

interface Fighter {
    val name: String
    val stat: Stat
    val equipment: Equipment
    fun fight(enemy: Fighter)
    fun defend(attack: Attack)
    fun isAlive(): Boolean
    fun rest()
    fun reset()
    fun equip(item: Item)
}