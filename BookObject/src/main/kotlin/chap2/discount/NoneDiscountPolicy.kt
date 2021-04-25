package chap2.discount

import chap2.Money
import chap2.Screening

class NoneDiscountPolicy : DiscountPolicy() {
    override fun getDiscountAmount(screening: Screening): Money = Money.ZERO
}
