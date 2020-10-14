class Warrior(name: String) : BaseFighter(name) {
    override val stat = Stat(
            200.0, 100.0, 10.0,
            1.0, 1.2, 0.8
    )

    override fun attack(): PhysicAttack {
        val damage: Double = stat.stamina * 0.5 * Math.random()
        this.stat.stamina -= damage
        return PhysicAttack(damage)
    }
}