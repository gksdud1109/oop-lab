package com.onezero.oop.settlement;

public class InvalidTransitionException extends RuntimeException {
    public InvalidTransitionException(SettlementStatus from, SettlementStatus to) {
        super("Invalid settlement status transition: " + from + " -> " + to);
    }
}

