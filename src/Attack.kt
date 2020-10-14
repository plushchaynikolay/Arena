abstract class Attack(val damage: Double) {
    abstract fun calculate(target: Fighter): Double
}

class PhysicAttack(damage: Double) : Attack(damage) {
    override fun calculate(target: Fighter): Double {
        println("${target.name} has ${format((1.0 - target.stat.physicResist) * 100)}% physical resist")
        return damage * target.stat.physicResist
    }
}

class PoisonAttack(damage: Double) : Attack(damage) {
    override fun calculate(target: Fighter): Double {
        println("${target.name} has ${format((1.0 - target.stat.poisonResist) * 100)}% poison resist")
        return damage * target.stat.poisonResist
    }
}

class MagicAttack(damage: Double) : Attack(damage) {
    override fun calculate(target: Fighter): Double {
        println("${target.name} has ${format((1.0 - target.stat.manaResist) * 100)}% magic resist")
        return damage * target.stat.manaResist
    }
}