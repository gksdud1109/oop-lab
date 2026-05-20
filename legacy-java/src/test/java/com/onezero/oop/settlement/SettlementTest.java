package com.onezero.oop.settlement;

import java.util.UUID;

public class SettlementTest {
    public static void main(String[] args) {
        allowsNormalTransition();
        blocksInvalidTransition();
        allowsCorrectionRequestAfterConfirmed();
        blocksConfirmingFailedSettlement();
        exposesCurrentStatus();
        System.out.println("SettlementTest passed");
    }

    private static void allowsNormalTransition() {
        Settlement settlement = new Settlement(UUID.randomUUID());

        settlement.transitionTo(SettlementStatus.AGGREGATING);
        settlement.transitionTo(SettlementStatus.VALIDATING);
        settlement.transitionTo(SettlementStatus.CONFIRMED);

        assertEquals(SettlementStatus.CONFIRMED, settlement.status());
    }

    private static void blocksInvalidTransition() {
        Settlement settlement = new Settlement(UUID.randomUUID());

        assertThrows(InvalidTransitionException.class, () -> settlement.transitionTo(SettlementStatus.CONFIRMED));
    }

    private static void allowsCorrectionRequestAfterConfirmed() {
        Settlement settlement = new Settlement(UUID.randomUUID());

        settlement.transitionTo(SettlementStatus.AGGREGATING);
        settlement.transitionTo(SettlementStatus.VALIDATING);
        settlement.transitionTo(SettlementStatus.CONFIRMED);
        settlement.transitionTo(SettlementStatus.CORRECTION_REQUESTED);

        assertEquals(SettlementStatus.CORRECTION_REQUESTED, settlement.status());
    }

    private static void blocksConfirmingFailedSettlement() {
        Settlement settlement = new Settlement(UUID.randomUUID());

        settlement.transitionTo(SettlementStatus.FAILED);

        assertThrows(InvalidTransitionException.class, () -> settlement.transitionTo(SettlementStatus.CONFIRMED));
    }

    private static void exposesCurrentStatus() {
        Settlement settlement = new Settlement(UUID.randomUUID());

        assertEquals(SettlementStatus.OPENED, settlement.status());
    }

    private static void assertEquals(Object expected, Object actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError("Expected " + expected + " but got " + actual);
        }
    }

    private static void assertThrows(Class<? extends Throwable> expectedType, Runnable action) {
        try {
            action.run();
        } catch (Throwable actual) {
            if (expectedType.isInstance(actual)) {
                return;
            }
            throw new AssertionError("Expected " + expectedType.getSimpleName() + " but got " + actual.getClass().getSimpleName(), actual);
        }
        throw new AssertionError("Expected " + expectedType.getSimpleName() + " to be thrown");
    }
}

