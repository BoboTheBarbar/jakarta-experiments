package com.colenio.jakartaeehelloworld2.entity;

public class Specifcation {
    private final Color color;
    private final EngineType engineType;

    public Specifcation(Color color, EngineType engineType) {
        this.color = color;
        this.engineType = engineType;
    }

    public Color getColor() {
        return color;
    }

    public EngineType getEngineType() {
        return engineType;
    }

}
