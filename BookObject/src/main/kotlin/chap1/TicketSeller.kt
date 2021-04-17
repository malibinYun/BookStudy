package chap1

class TicketSeller(
    private val ticketOffice: TicketOffice,
){
    fun sellTo(audience: Audience){
        ticketOffice.sellTicketTo(audience)
    }

//    fun sellTo(audience: Audience){
//        val ticket = ticketOffice.getTicket()
//        val fee = audience.buy(ticket)
//        ticketOffice.plusAmount(fee)
//    }
    /**
     주석처럼 작성하면 TicketOffice는 Audience에 대해 알지 않아도 된다.
     하지만 TicketOffice의 자율성을 해친다.

     기존 처럼 작성하면, TicketSeller가 Audience를 알고, TicketOffice도 Audience에 대한 의존성을 가진다.
     하지만, TicketOffice는 자율성을 가진 객체가 된다.

     여기서 불필요한 의존성의 제거가 맞느냐, 또는 자율적인 객체를 만드는 게 맞느냐는
     취향차이, 팀바팀 이라고도 할 수 있고, 팀의 지향성을 따라가는 게 맞다고 본다.

     설계는 결코 답이 존재하지 않고, 장단점이 생긴다.
     어떤 것을 우선할 것인지. 적절한 트레이드오프가 필요하며 그렇게 해야만 훌륭한 설계가 나온다.
     */
}
