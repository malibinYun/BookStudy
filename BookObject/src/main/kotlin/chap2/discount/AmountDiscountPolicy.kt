package chap2.discount

import chap2.Money
import chap2.Screening
import chap2.discount.condition.DiscountCondition

class AmountDiscountPolicy(
    private val discountAmount: Money,
    discountConditions: List<DiscountCondition>,
) : DiscountPolicy(discountConditions) {

    constructor(discountAmount: Money, vararg conditions: DiscountCondition) : this(discountAmount, listOf(*conditions))

    override fun getDiscountAmount(screening: Screening): Money {
        return discountAmount
    }
}
