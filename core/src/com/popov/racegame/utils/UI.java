package com.popov.racegame.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class UI {
    private Stage stage;
    private Skin skin;
    private Label label;

    public UI(){
        stage = new Stage(new FitViewport(800, 600));
        skin = new Skin(Gdx.files.internal("skin.json"));
        addLabelToStage();
    }

    private void addLabelToStage() {
        label = new Label("Hello!\nMy name is Aleksey.", skin.get("default", Label.LabelStyle.class));
        label.setAlignment(Align.center);
        label.setPosition(400, 300, Align.center);
        label.setFontScale(1f);
        stage.addActor(label);
    }

    public void draw() {
        stage.getViewport().update(
                Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight()
        );
        stage.act();
        stage.draw();
    }

    public void dispose() {
        stage.dispose();
    }
}
