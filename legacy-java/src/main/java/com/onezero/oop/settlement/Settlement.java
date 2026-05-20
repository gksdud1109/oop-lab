package com.onezero.oop.settlement;

import java.util.Objects;
import java.util.UUID;

public class Settlement {
    private final UUID id;
    private SettlementStatus status;

    public Settlement(UUID id) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.status = SettlementStatus.OPENED;
    }

    public UUID id() {
        return id;
    }

    public SettlementStatus status() {
        return status;
    }

    public void transitionTo(SettlementStatus next) {
        Objects.requireNonNull(next, "next status must not be null");
        if (!status.canTransitionTo(next)) {
            throw new InvalidTransitionException(status, next);
        }
        this.status = next;
    }
}

