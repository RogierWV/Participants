package io.snynx.participants;

import java.io.Serializable;

/**
 * Record for holding all data for participations
 */
public record Participation(String name, int h, int m) implements Serializable {

    @Override
    public String toString() {
        return String.format("%s at %02d:%02d", name, h, m); // name at 00:00
    }

    public boolean checkConstraints() {
        if (h > 23) throw new IllegalArgumentException("Hours > 23!");
        if (h < 0) throw new IllegalArgumentException("Hours < 0!");
        if (m > 59) throw new IllegalArgumentException("Minutes > 59!");
        if (m < 0) throw new IllegalArgumentException("Minutes < 0!");
        if ("".equals(name)) throw new IllegalArgumentException("Name empty!");
        return true;
    }
}
