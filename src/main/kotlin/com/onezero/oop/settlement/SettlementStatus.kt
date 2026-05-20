package com.onezero.oop.settlement

enum class SettlementStatus {
    OPENED,
    AGGREGATING,
    VALIDATING,
    CONFIRMED,
    FAILED,
    CORRECTION_REQUESTED,
    CORRECTED,
    ;

    fun canTransitionTo(next: SettlementStatus): Boolean = next in allowedTargets()

    private fun allowedTargets(): Set<SettlementStatus> =
        when (this) {
            OPENED -> setOf(AGGREGATING, FAILED)
            AGGREGATING -> setOf(VALIDATING, FAILED)
            VALIDATING -> setOf(CONFIRMED, FAILED)
            CONFIRMED -> setOf(CORRECTION_REQUESTED)
            CORRECTION_REQUESTED -> setOf(CORRECTED, FAILED)
            CORRECTED, FAILED -> emptySet()
        }
}
