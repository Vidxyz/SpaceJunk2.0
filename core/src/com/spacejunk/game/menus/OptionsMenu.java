package com.spacejunk.game.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.spacejunk.game.GameScreen;
import com.spacejunk.game.SpaceJunk;

/**
 * Created by vidxyz on 2/9/18.
 */

public class OptionsMenu {

    // BUTTON_0 <==> MAIN MENU
    // BUTTON_1 <==> PLAY/PAUSE
    // BUTTON_2 <==> RESTART

    public static final int MAX_BUTTONS = 3;

    private Texture[] optionsMenuTexures;

    private Texture screenRecordButton;
    private SpaceJunk currentGame;

    public OptionsMenu(SpaceJunk currentGame) {

        this.currentGame = currentGame;

        optionsMenuTexures = new Texture[MAX_BUTTONS];

        optionsMenuTexures[0] = this.currentGame.getManager().get("main_menu.png");
        optionsMenuTexures[1] = this.currentGame.getManager().get("pause_button.png");
        optionsMenuTexures[2] = this.currentGame.getManager().get("settings_menu.png");

        screenRecordButton = this.currentGame.getManager().get("screen_record.png");
    }

    public void render(SpriteBatch canvas) {


        // Render the options menu buttons
        for(int i = 0; i < MAX_BUTTONS; i++) {
            if(i != 0) {
                canvas.draw(optionsMenuTexures[i], 0,
                        Gdx.graphics.getHeight() - ((i+1) * GameScreen.getScaledTextureHeight(optionsMenuTexures[i])),
                        GameScreen.getScaledTextureWidth(optionsMenuTexures[i]),
                        GameScreen.getScaledTextureHeight(optionsMenuTexures[i]));
            }
            else {
                canvas.draw(optionsMenuTexures[i], 0,
                        Gdx.graphics.getHeight() - ((i+1) * GameScreen.getScaledTextureHeight(optionsMenuTexures[i])),
                        GameScreen.getScaledTextureWidth(optionsMenuTexures[i]),
                        GameScreen.getScaledTextureHeight(optionsMenuTexures[i]));
            }
        }

        // Render the screen record button
//        canvas.draw(screenRecordButton, (int) (GameScreen.getScaledTextureWidth(screenRecordButton) * 0.1), 0,
//                GameScreen.getScaledTextureWidth(screenRecordButton),
//                GameScreen.getScaledTextureHeight(screenRecordButton));
    }

    public Texture[] getOptionsMenuTexures() {
        return optionsMenuTexures;
    }

    public void setMiddleButtonTextureToPlay() {
        optionsMenuTexures[1] = currentGame.getManager().get("play_button.png");
    }

    public void setMiddleButtonTextureToPause() {
        optionsMenuTexures[1] = currentGame.getManager().get("pause_button.png");
    }

    public Texture getScreenRecordButton() {
        return screenRecordButton;
    }
}
