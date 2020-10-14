package fighter

class Warrior(name: String) : BaseFighter(name) {
    override val stat = Stat(
            200.0, 100.0, 10.0,
            0.0, 0.2, -0.2,
            0.5, 0.3, 0.0
    )

    override fun attack(): PhysicAttack {
        val damage: Double = stat.stamina * stat.power * Math.random()
        this.stat.stamina -= damage
        return PhysicAttack(damage)
    }
}