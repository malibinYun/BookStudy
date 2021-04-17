package chap1

class Bag private constructor(
    private var amount: Long,
    private val invitation: Invitation?,
    var ticket: Ticket?,
) {
    constructor(amount: Long, invitation: Invitation) : this(amount, invitation, null)

    constructor(amount: Long) : this(amount, null, null)

    fun hasInvitation(): Boolean = invitation == null

    fun hasTicket(): Boolean = ticket == null

    fun plusAmount(amount: Long) {
        this.amount += amount
    }

    fun minusAmount(amount: Long) {
        this.amount -= amount
    }
}
