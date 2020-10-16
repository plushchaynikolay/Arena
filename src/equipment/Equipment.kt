package equipment

import fighter.IStat
import fighter.Stat

class Equipment(private val stat: Stat) : IStat {
    val equipmentList: MutableList<Item> = mutableListOf()
    override val poisonResist: Double
        get() {
            var acc = 0.0
            equipmentList.forEach { acc += it.poisonResist }
            return acc + stat.poisonResist
        }
    override val physicResist: Double
        get() {
            var acc = 0.0
            equipmentList.forEach { acc += it.physicResist }
            return acc + stat.physicResist
        }
    override val manaResist: Double
        get() {
            var acc = 0.0
            equipmentList.forEach { acc += it.manaResist }
            return acc + stat.manaResist
        }
    override val power: Double
        get() {
            var acc = 0.0
            equipmentList.forEach { acc += it.power }
            return acc + stat.power
        }
    override val protection: Double
        get() {
            var acc = 0.0
            equipmentList.forEach { acc += it.protection }
            return acc + stat.protection
        }
    override val willpower: Double
        get() {
            var acc = 0.0
            equipmentList.forEach { acc += it.willpower }
            return acc + stat.willpower
        }

    override fun toString(): String {
        var acc = ""
        equipmentList.forEachIndexed { index, item ->
            acc += "${index + 1}) $item"
            if (index < equipmentList.size - 1)
                acc += "\n"
        }
        return acc
    }
}