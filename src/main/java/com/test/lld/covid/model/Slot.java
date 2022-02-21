package com.test.lld.covid.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Slot {

    private long startTime;
    private long endTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Slot slot = (Slot) o;
        return startTime == slot.startTime &&
                endTime == slot.endTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, endTime);
    }
}
