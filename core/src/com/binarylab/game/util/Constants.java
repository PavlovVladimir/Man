package com.binarylab.game.util;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Constants {
    public static final String TAG = Constants.class.getName();

    public static final Color BACKGROUND_COLOR = Color.FOREST;//new Color(1,1,1,1);
    public static final String TEXTURE_ATLAS = "images/codecar.pack.atlas";

    public static final float WORLD_SIZE_HEGHT = 320;
    public static final float WORLD_SIZE_WIDTH = 640;
    public static final float TITLE_SIZE = 32;

    public static final float GRAVITY = 10;

    // Assets for Car
    public static final String STANDING_RIGHT = "standing_right";
    public static final String STANDING_LEFT = "standing_left";
    public static final String STANDING_UP = "standing_up";
    public static final String STANDING_DOWN = "standing_down";

    public static final String WALKING_LEFT_1 = "moving_left1";
    public static final String WALKING_LEFT_2 = "moving_left2";
    public static final String WALKING_LEFT_3 = "moving_left3";
    public static final String WALKING_LEFT_4 = "moving_left4";

    public static final String WALKING_RIGHT_1 = "moving_right1";
    public static final String WALKING_RIGHT_2 = "moving_right2";
    public static final String WALKING_RIGHT_3 = "moving_right3";
    public static final String WALKING_RIGHT_4 = "moving_right4";

    public static final String WALKING_UP_1 = "moving_up1";
    public static final String WALKING_UP_2 = "moving_up2";
    public static final String WALKING_UP_3 = "moving_up3";
    public static final String WALKING_UP_4 = "moving_up4";

    public static final String WALKING_DOWN_1 = "moving_down1";
    public static final String WALKING_DOWN_2 = "moving_down2";
    public static final String WALKING_DOWN_3 = "moving_down3";
    public static final String WALKING_DOWN_4 = "moving_down4";

    // Constants fo car:
    public static final Vector2 CAR_MEDIUM_POSITION = new Vector2(16, 16);
    public static final float CODECAR_STEP = WORLD_SIZE_HEGHT / (WORLD_SIZE_HEGHT / TITLE_SIZE);
    public static final float CODECAR_WIDTH = WORLD_SIZE_HEGHT / TITLE_SIZE;
    public static final float CODECAR_SPEED = 50f;

    // For road
    public static final String ROAD_ASSET = "road";
    public static final float ROAD_WIDTH = WORLD_SIZE_HEGHT / TITLE_SIZE;

    // For other objects
    public static final String TREE_ASSET = "forest2";
    public static final String GRASS_ASSET = "trava";
    public static final String STONE_ASSET = "stones";

    public static final float WALK_LOOP_DURATION = 0.4f;


    public static final String FINISH_ASSET = "finish";

    // Overlays
    public static final String FONT_FILE = "font/header.fnt";
    public static final float LEVEL_END_DURATION = 5;
    public static final String VICTORY_MESSAGE = "You are the Winner! \n Next level loading...";
    public static final String GAME_OVER_MESSAGE = "Game Over. \n Try again!";

    // Assets for commandOverlay:
    public static final String COMMAND_GRID = "grid";
    public static final String COMMAND_RIGHT = "command_right";
    public static final String COMMAND_LEFT = "command_left";
    public static final String COMMAND_UP = "command_up";
    public static final String COMMAND_DOWN = "command_down";
    public static final String COMMAND_TAKE = "command_take";
    public static final String COMMAND_PLAY = "play";

}
