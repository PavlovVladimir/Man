package com.binarylab.game.util;

import com.badlogic.gdx.math.Vector2;
import com.binarylab.game.util.Enums.Direction;

public class Path {
    Vector2 nextPoint;
    Direction direction;

    public Path(Vector2 nextPoint, Direction direction) {
        this.nextPoint = nextPoint;
        this.direction = direction;
    }

    public Vector2 getNextPoint() {
        return nextPoint;
    }

    public Direction getDirection() {
        return direction;
    }

}
