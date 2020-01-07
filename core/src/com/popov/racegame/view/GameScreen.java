package com.popov.racegame.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.popov.racegame.model.Car;
import com.popov.racegame.utils.UI;

public class GameScreen implements Screen {

    private TextureAtlas textureAtlas;
    private UI ui;

    private SpriteBatch spriteBatch;
    private Car car;
    private OrthographicCamera camera;
    static public float deltaCff = 0;

    public void setTextureAtlas(TextureAtlas textureAtlas) {
        this.textureAtlas = textureAtlas;
    }

    @Override
    public void show() {
        spriteBatch = new SpriteBatch();
        car = new Car(textureAtlas.findRegion("car"), 0, 0, 1, 2);
        ui = new UI();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        deltaCff = delta;

        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        car.draw(spriteBatch);
        spriteBatch.end();
        ui.draw();
    }

    @Override
    public void resize(int width, int height) {
        float aspectRatio = width / height;
        camera = new OrthographicCamera(20, 20*aspectRatio);
        camera.zoom = 0.5f;
        camera.update();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        ui.draw();
    }
}
