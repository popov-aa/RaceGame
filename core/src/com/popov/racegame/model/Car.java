package com.popov.racegame.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.popov.racegame.controller.CarController;

public class Car extends GameObject {

    private CarController carController;

    public Car(TextureRegion textureRegion, float x, float y, float width, float height) {
        super(textureRegion, x, y, width, height);
        carController = new CarController(bounds);
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        super.draw(spriteBatch);
        carController.handle();
    }
}
