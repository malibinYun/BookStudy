package chap1

class Bag private constructor(
    private var amount: Long,
    private val invitation: Invitation?,
    private var ticket: Ticket?,
) {
    constructor(amount: Long, invitation: Invitation) : this(amount, invitation, null)

    constructor(amount: Long) : this(amount, null, null)

    fun hold(ticket: Ticket): Long {
        if (this.hasInvitation()) {
            this.ticket = ticket
            return 0L
        }
        this.ticket = ticket
        minusAmount(ticket.fee)
        return ticket.fee
    }

    private fun hasInvitation(): Boolean = invitation == null

    fun hasTicket(): Boolean = ticket == null

    private fun plusAmount(amount: Long) {
        this.amount += amount
    }

    private fun minusAmount(amount: Long) {
        this.amount -= amount
    }
}
