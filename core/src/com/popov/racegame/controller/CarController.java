package com.popov.racegame.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.popov.racegame.view.GameScreen;

public class CarController {

    private Polygon polygon;
    private float speed = 0f, velocity = 3f, speedMax = 10f, reverseSpeedMax = 5f;
    private float rotationSpeed = 30f;

    public CarController(Polygon polygon) {
        this.polygon = polygon;
    }

    public void handle() {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            speed += velocity*GameScreen.deltaCff;
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            speed -= velocity*GameScreen.deltaCff;
        } else {
            downSpeed();
        }
        speed = sliceSpeen(speed);

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            polygon.rotate(rotationSpeed * speed * GameScreen.deltaCff);
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            polygon.rotate(-rotationSpeed * speed * GameScreen.deltaCff);
        }

        this.polygon.setPosition(
                polygon.getX() + MathUtils.cosDeg(polygon.getRotation() + 90) * speed * GameScreen.deltaCff,
                polygon.getY() + MathUtils.sinDeg(polygon.getRotation() + 90) * speed * GameScreen.deltaCff);
    }

    private void downSpeed() {
        if (speed > velocity*GameScreen.deltaCff) {
            speed -= velocity*GameScreen.deltaCff;
        } else if (speed < -velocity*GameScreen.deltaCff) {
            speed += velocity*GameScreen.deltaCff;
        } else {
            speed = 0;
        }
    }

    private float sliceSpeen(float speed) {
        if (speed > speedMax) {
            return speedMax;
        } if (speed < -reverseSpeedMax) {
            return -reverseSpeedMax;
        } else {
            return speed;
        }
    }
}
