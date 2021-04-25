package chap2.discount

import chap2.Money
import chap2.Screening
import chap2.discount.condition.DiscountCondition

abstract class DiscountPolicy(
    private val conditions: List<DiscountCondition>
) {
    constructor(vararg conditions: DiscountCondition) : this(listOf(*conditions))

    fun calculateDiscountAmount(screening: Screening): Money {
        conditions.forEach {
            if (it.isSatisfiedBy(screening)) return getDiscountAmount(screening)
        }
        return Money.ZERO
    }

    protected abstract fun getDiscountAmount(screening: Screening): Money
}
