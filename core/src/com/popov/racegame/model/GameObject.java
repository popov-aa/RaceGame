package com.popov.racegame.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;

public abstract class GameObject {
    protected Polygon bounds;
    protected Sprite sprite;

    public GameObject(TextureRegion textureRegion, float x, float y, float width, float height) {
        sprite = new Sprite(textureRegion);
        sprite.setSize(width, height);
        sprite.setPosition(x, y);
        sprite.setOrigin(width / 2f, height / 2f);

        bounds = new Polygon(new float[]{0f, 0f, width, 0f, width, height, 0f, height});
        bounds.setPosition(x, y);
        bounds.setOrigin(width / 2f, height / 2f);
    }

    public void draw(SpriteBatch spriteBatch) {
        sprite.setPosition(bounds.getX(), bounds.getY());
        sprite.setRotation(bounds.getRotation());
        sprite.draw(spriteBatch);
    }
}
