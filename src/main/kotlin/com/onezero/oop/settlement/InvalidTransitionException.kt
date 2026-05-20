package com.onezero.oop.settlement

class InvalidTransitionException(
    from: SettlementStatus,
    to: SettlementStatus,
) : IllegalStateException("Invalid settlement status transition: $from -> $to")
