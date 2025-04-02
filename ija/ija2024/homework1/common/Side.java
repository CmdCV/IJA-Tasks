package ija.ija2024.homework1.common;

public enum Side {
    NORTH, EAST, SOUTH, WEST;

    public Side next() {
        return values()[(this.ordinal() + 1) % values().length];
    }
}
