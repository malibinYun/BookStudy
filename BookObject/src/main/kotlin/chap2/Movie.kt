package chap2

import chap2.discount.AmountDiscountPolicy
import chap2.discount.DiscountPolicy
import chap2.discount.NoneDiscountPolicy
import chap2.discount.PercentDiscountPolicy
import chap2.discount.condition.PeriodCondition
import chap2.discount.condition.SequenceCondition
import java.time.DayOfWeek
import java.time.Duration
import java.time.LocalTime

class Movie(
    val title: String,
    val runningTime: Duration,
    val fee: Money,
    private var discountPolicy: DiscountPolicy,
) {
    fun calculateMovieFee(screening: Screening): Money {
        return fee - discountPolicy.calculateDiscountAmount(screening)
    }

    fun changeDiscountPolicy(discountPolicy: DiscountPolicy) {
        this.discountPolicy = discountPolicy
    }

    companion object {
        val AVATAR: Movie = Movie(
            title = "아바타",
            runningTime = Duration.ofMinutes(120L),
            fee = Money.wons(10_000L),
            discountPolicy = AmountDiscountPolicy(
                discountAmount = Money.wons(800),
                SequenceCondition(1),
                SequenceCondition(10),
                PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59)),
            ),
        )
        val TITANIC: Movie = Movie(
            title = "타이타닉",
            runningTime = Duration.ofMinutes(180L),
            fee = Money.wons(11_000L),
            discountPolicy = PercentDiscountPolicy(
                percent = 0.1,
                PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)),
                SequenceCondition(2),
                PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(13, 59)),
            ),
        )
        val STAR_WARS: Movie = Movie(
            title = "스타워즈",
            runningTime = Duration.ofMinutes(210L),
            fee = Money.wons(10_000L),
            discountPolicy = NoneDiscountPolicy(),
        )
    }
}
