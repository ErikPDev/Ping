/**
 * A Static Class for global configuration
 */
public class GlobalConfig {
    public enum GameMode { SLIDING_AI, BOT, TWO_PLAYER }
    private static GameMode gameMode = GameMode.SLIDING_AI; // 0 is Sliding Paddle, 1 is Computer Bot

    public static GameMode getGameMode() {
        return gameMode;
    }

    public static void setGameMode(GameMode gameMode) {
        GlobalConfig.gameMode = gameMode;
    }

}
