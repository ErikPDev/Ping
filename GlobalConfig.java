/**
 * A Static Class for global configuration
 */
public class GlobalConfig {
    private static int gameMode = 0; // 0 is Sliding Paddle, 1 is Computer Bot

    public static int getGameMode() {
        return gameMode;
    }

    public static void setGameMode(int gameMode) {
        GlobalConfig.gameMode = gameMode;
    }

}
