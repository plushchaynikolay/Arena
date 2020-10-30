package fighter

import format

abstract class Attack(val damage: Double) {
    //    Посетитель
    abstract fun calculate(target: Fighter): Double
}

class PhysicAttack(damage: Double) : Attack(damage) {
    override fun calculate(target: Fighter): Double {
        println("${target.name} has ${format(target.stat.physicResist * 100)}% physical resist")
        return damage * (1.0 - target.equipment.physicResist)
    }
}

class PoisonAttack(damage: Double) : Attack(damage) {
    override fun calculate(target: Fighter): Double {
        println("${target.name} has ${format(target.stat.poisonResist * 100)}% poison resist")
        return damage * (1.0 - target.stat.poisonResist)
    }
}

class MagicAttack(damage: Double) : Attack(damage) {
    override fun calculate(target: Fighter): Double {
        println("${target.name} has ${format(target.stat.manaResist * 100)}% magic resist")
        return damage * (1.0 - target.stat.manaResist)
    }
}