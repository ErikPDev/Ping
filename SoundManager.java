import greenfoot.Greenfoot;

public class SoundManager {
    private static final String WALL_HIT_AUDIO = "wall-hit.wav";
    private static final String GAME_WIN_AUDIO = "game-over.wav";
    private static final String SCORE_POINT_AUDIO = "point-scored.wav";
    private static final String PADDLE_HIT_AUDIO = "paddle-hit.wav";
    private static final String MENU_HOVER_AUDIO = "gamemode-hover.mp3";
    private static final String MENU_CLICK_AUDIO = "button-click.wav";
    private static final String GAME_OVER_AUDIO = "game-over.wav";
    private static final String BOT_SCORE_AUDIO = "bot-score.wav";
    static void playWallHit() {
        Greenfoot.playSound(WALL_HIT_AUDIO);
    }

    static void playGameWin() {
        Greenfoot.playSound(GAME_WIN_AUDIO);
    }

    static void playScorePoint() {
        Greenfoot.playSound(SCORE_POINT_AUDIO);
    }

    static void playPaddleHit() {
        Greenfoot.playSound(PADDLE_HIT_AUDIO);
    }

    static void playButtonHover() {
        Greenfoot.playSound(MENU_HOVER_AUDIO);
    }

    static void playButtonClick() {
        Greenfoot.playSound(MENU_CLICK_AUDIO);
    }
    
    static void playGameOver() {
        Greenfoot.playSound(GAME_OVER_AUDIO);
    }
    
    static void playBotScore() {
        Greenfoot.playSound(BOT_SCORE_AUDIO);
    }

}
