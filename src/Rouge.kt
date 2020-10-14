class Rouge(name: String) : BaseFighter(name) {
    override val stat = Stat(
            100.0, 150.0, 10.0,
            0.8, 1.0, 1.2
    )

    override fun attack(): PoisonAttack {
        val damage: Double = stat.stamina * Math.random()
        this.stat.stamina -= damage
        return PoisonAttack(damage)
    }
}