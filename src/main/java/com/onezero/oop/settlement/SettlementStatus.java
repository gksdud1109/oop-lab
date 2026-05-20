package com.onezero.oop.settlement;

import java.util.EnumSet;
import java.util.Set;

public enum SettlementStatus {
    OPENED,
    AGGREGATING,
    VALIDATING,
    CONFIRMED,
    FAILED,
    CORRECTION_REQUESTED,
    CORRECTED;

    public boolean canTransitionTo(SettlementStatus next) {
        return allowedTargets().contains(next);
    }

    private Set<SettlementStatus> allowedTargets() {
        return switch (this) {
            case OPENED -> EnumSet.of(AGGREGATING, FAILED);
            case AGGREGATING -> EnumSet.of(VALIDATING, FAILED);
            case VALIDATING -> EnumSet.of(CONFIRMED, FAILED);
            case CONFIRMED -> EnumSet.of(CORRECTION_REQUESTED);
            case CORRECTION_REQUESTED -> EnumSet.of(CORRECTED, FAILED);
            case CORRECTED, FAILED -> EnumSet.noneOf(SettlementStatus.class);
        };
    }
}

