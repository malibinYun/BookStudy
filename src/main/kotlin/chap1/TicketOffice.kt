package chap1

class TicketOffice(
    private var amount: Long,
    private val tickets: MutableList<Ticket> = mutableListOf(),
) {
    constructor(amount: Long, vararg tickets: Ticket) : this(amount, mutableListOf(*tickets))

    fun getTicket(): Ticket {
        return tickets.removeAt(0)
    }

    fun plusAmount(amount: Long) {
        this.amount += amount
    }

    fun minusAmount(amount: Long) {
        this.amount -= amount
    }
}
