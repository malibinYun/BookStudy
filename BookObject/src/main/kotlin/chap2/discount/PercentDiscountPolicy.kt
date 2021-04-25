package chap2.discount

import chap2.Money
import chap2.Screening
import chap2.discount.condition.DiscountCondition

class PercentDiscountPolicy(
    private val percent: Double,
    discountConditions: List<DiscountCondition>,
) : DiscountPolicy(discountConditions) {

    constructor(percent: Double, vararg conditions: DiscountCondition) : this(percent, listOf(*conditions))

    override fun getDiscountAmount(screening: Screening): Money {
        return screening.getMovieFee() * percent
    }
}
