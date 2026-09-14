import greenfoot.*;

public class SoundManager {
    private static final String WALL_HIT_AUDIO = "wall_hit.wav";
    private static final String GAME_WIN_AUDIO = "game_win.wav";
    private static final String SCORE_POINT_AUDIO = "score_point.wav";
    private static final String PADDLE_HIT_AUDIO = "paddle_hit.wav";

    static void playWallHit(){
        Greenfoot.playSound(WALL_HIT_AUDIO);
    }

    static void playGameWin(){
        Greenfoot.playSound(GAME_WIN_AUDIO);
    }

    static void playScorePoint(){
        Greenfoot.playSound(SCORE_POINT_AUDIO);
    }

    static void playPaddleHit(){
        Greenfoot.playSound(PADDLE_HIT_AUDIO);
    }
}
