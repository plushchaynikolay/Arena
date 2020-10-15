package equipment

import fighter.IStat

class Item(
        private val name: String,
        override val poisonResist: Double,
        override val physicResist: Double,
        override val manaResist: Double,
        override val power: Double,
        override val protection: Double,
        override val willpower: Double
) : IStat {
    override fun toString(): String = name
}