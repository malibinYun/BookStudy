package chap1

class TicketOffice(
    private var amount: Long,
    private val tickets: MutableList<Ticket> = mutableListOf(),
) {
    constructor(amount: Long, vararg tickets: Ticket) : this(amount, mutableListOf(*tickets))

    fun sellTicketTo(audience: Audience){
        val fee = audience.buy(getTicket())
        plusAmount(fee)
    }

    private fun getTicket(): Ticket {
        return tickets.removeAt(0)
    }

    private fun plusAmount(amount: Long) {
        this.amount += amount
    }

    private fun minusAmount(amount: Long) {
        this.amount -= amount
    }
}
