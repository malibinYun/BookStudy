package chap2.discount.condition

import chap2.Screening

class SequenceCondition(
    private val sequence: Int,
) : DiscountCondition {

    override fun isSatisfiedBy(screening: Screening): Boolean {
        return screening.isSequence(sequence)
    }
}
