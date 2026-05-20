package com.onezero.oop.settlement

import java.util.UUID

class Settlement(
    val id: UUID = UUID.randomUUID(),
) {
    var status: SettlementStatus = SettlementStatus.OPENED
        private set

    fun transitionTo(next: SettlementStatus) {
        if (!status.canTransitionTo(next)) {
            throw InvalidTransitionException(status, next)
        }
        status = next
    }
}
