package ija.ija2024.homework1.common;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public class GameNode {
    public enum Type {
        BULB, LINK, POWER, EMPTY
    }
    private Type type;
    private Position position;
    private Set<Side> sides;

    public GameNode(Position position, Type type, Side... sides) {
        this.type = type;
        this.position = position;
        this.sides = EnumSet.noneOf(Side.class);
        Collections.addAll(this.sides, sides);
    }

    public boolean containsConnector(Side s) {
        return this.sides.contains(s);
    }

    public Position getPosition() {
        return this.position;
    }

    public boolean isLink() {
        return this.type == Type.LINK;
    }

    public boolean isBulb() {
        return this.type == Type.BULB;
    }

    public boolean isPower() {
        return this.type == Type.POWER;
    }

    public void turn() {
        Set<Side> newSides = EnumSet.noneOf(Side.class);
        for (Side side : this.sides) {
            newSides.add(side.next());
        }
        this.sides = newSides;
    }
}
