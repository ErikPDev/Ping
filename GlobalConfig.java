/**
 * A Static Class for global configuration
 */
public class GlobalConfig {
    private static GameMode gameMode = GameMode.SLIDING_AI;

    public static GameMode getGameMode() {
        return gameMode;
    }

    public static void setGameMode(GameMode gameMode) {
        GlobalConfig.gameMode = gameMode;
    }

    public enum GameMode {SLIDING_AI, BOT, TWO_PLAYER}

}
