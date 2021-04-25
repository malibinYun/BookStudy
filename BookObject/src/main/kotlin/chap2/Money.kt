package chap2

import java.math.BigDecimal

data class Money(
    private val amount: BigDecimal,
) {
    operator fun plus(other: Money): Money = Money(this.amount + other.amount)
    operator fun minus(other: Money): Money = Money(this.amount - other.amount)
    operator fun times(percent: Double): Money = Money(this.amount * BigDecimal.valueOf(percent))
    operator fun times(intValue: Int): Money = Money(this.amount * BigDecimal(intValue))
    operator fun compareTo(other: Money) = this.amount.compareTo(other.amount)

    companion object {
        val ZERO: Money = wons(0)
        fun wons(amount: Long): Money = Money(BigDecimal(amount))
        fun wons(amount: Double): Money = Money(BigDecimal(amount))
    }
}
