package com.balloon.game.handlers;

public class StarHandler {
    public StarHandler() {
        goldStarsCollected = 0;
        silverStarsCollected = 0;
    }

    public static void withStars(int s) {
        goldStarLimit = s;
    }

    public static void goldStarCollected() {
        goldStarsCollected++;
    }

    public static void silverStarCollected() {
        silverStarsCollected++;
    }

    public static int getSilverStarsCollected() {
        return silverStarsCollected;
    }

    public static boolean isAllGoldStarsCollected() {
        return goldStarsCollected >= goldStarLimit;
    }

    public static void reset() {
        goldStarsCollected = 0;
        silverStarsCollected = 0;
    }

    private static int silverStarsCollected;
    private static int goldStarsCollected;
    private static int goldStarLimit;
}
