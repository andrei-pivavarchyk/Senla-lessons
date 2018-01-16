package com.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

public enum RoomStatus {
    RESERVED("reserved"),
    FREE("free"),
    REPAIRABLE("repairable");

    private String status;

    RoomStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
