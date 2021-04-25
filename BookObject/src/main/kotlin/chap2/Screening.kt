package chap2

import java.time.LocalDateTime

class Screening(
    private val movie: Movie,
    private val sequence: Int,
    val startTime: LocalDateTime
) {
    fun isSequence(sequence: Int): Boolean = this.sequence == sequence

    fun getMovieFee(): Money = movie.fee

    private fun calculateFee(audienceCount: Int): Money {
        return movie.calculateMovieFee(this) * audienceCount
    }

    fun reserve(customer: Customer, audienceCount: Int): Reservation {
        return Reservation(customer, this, calculateFee(audienceCount), audienceCount)
    }
}
