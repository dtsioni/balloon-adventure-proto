package com.balloon.game.handlers;

public class MineHandler {
    public static void mineExploded() {
        minesExploded++;
    }

    public static boolean isGameOver() {
        return minesExploded >= MINE_LIMIT;
    }

    public static void reset() {
        minesExploded = 0;
    }

    private static int minesExploded = 0;
    private static final int MINE_LIMIT = 1;
}
