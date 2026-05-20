package com.onezero.oop.settlement

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class SettlementTest {
    @Test
    fun `정상 정산 전이를 허용한다`() {
        val settlement = Settlement()

        settlement.transitionTo(SettlementStatus.AGGREGATING)
        settlement.transitionTo(SettlementStatus.VALIDATING)
        settlement.transitionTo(SettlementStatus.CONFIRMED)

        assertEquals(SettlementStatus.CONFIRMED, settlement.status)
    }

    @Test
    fun `잘못된 전이를 차단한다`() {
        val settlement = Settlement()

        assertFailsWith<InvalidTransitionException> {
            settlement.transitionTo(SettlementStatus.CONFIRMED)
        }
    }

    @Test
    fun `확정 후 정정 요청을 허용한다`() {
        val settlement = Settlement()

        settlement.transitionTo(SettlementStatus.AGGREGATING)
        settlement.transitionTo(SettlementStatus.VALIDATING)
        settlement.transitionTo(SettlementStatus.CONFIRMED)
        settlement.transitionTo(SettlementStatus.CORRECTION_REQUESTED)

        assertEquals(SettlementStatus.CORRECTION_REQUESTED, settlement.status)
    }

    @Test
    fun `실패 상태에서 확정으로 돌아갈 수 없다`() {
        val settlement = Settlement()

        settlement.transitionTo(SettlementStatus.FAILED)

        assertFailsWith<InvalidTransitionException> {
            settlement.transitionTo(SettlementStatus.CONFIRMED)
        }
    }

    @Test
    fun `현재 상태를 조회할 수 있다`() {
        val settlement = Settlement()

        assertEquals(SettlementStatus.OPENED, settlement.status)
    }
}
