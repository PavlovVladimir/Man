package com.binarylab.game.util;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Vector2;

public class Constants {
    public static final String TAG = Constants.class.getName();

    public static final Color BACKGROUND_COLOR = Color.SKY;//new Color(1,1,1,1);
    public static final String TEXTURE_ATLAS = "images/man.pack.atlas";

    public static final float WORLD_SIZE_HEGHT = 320;
    public static final float WORLD_SIZE_WIDTH = 640;
    public static final float TILE_SIZE = 32;

    public static final float GRAVITY = 12;

    // Assets for Man
    public static final String STANDING = "man";
    public static final String SHIT_ASSET = "shit";


    // Constants fo Man:
    public static final Vector2 MAN_MEDIUM_POSITION = new Vector2(16, 16);
    public static final float MAN_SPEED = 50f;


    // Overlays
    public static final String FONT_FILE = "font/header.fnt";
    public static final float LEVEL_END_DURATION = 5;
    public static final String VICTORY_MESSAGE = "You are the Winner! \n Next level loading...";
    public static final String GAME_OVER_MESSAGE = "Game Over. \n Try again!";

    public static final Vector2 SHIT_CENTER = new Vector2(32,32);
    public static final float SHIT_SPAWNS_PER_SECOND = 5.0f;
    public static final Vector2 SHIT_ACCELERATION = new Vector2(0, -30.0f);
    public static final float PLAYER_MOVEMENT_SPEED = 200.0f;
    public static final int INITIAL_LIVES = 3;
    public static final float HUD_VIEWPORT_SIZE = 480;
    public static final String HUD_SCORE_LABEL = "Score: ";
    public static final float HUD_MARGIN = 20;
    public static final String MAN1 = "man1";
    public static final String MAN2 = "man2";
    public static final String MAN3 = "man3";
    public static final String MAN4 = "man4";
    public static final float LOOP_DURATION = 0.25f;
}
