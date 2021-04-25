package chap2.discount.condition

import chap2.Screening

interface DiscountCondition {

    fun isSatisfiedBy(screening: Screening): Boolean
}
