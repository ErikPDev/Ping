import greenfoot.*;

public abstract class Button extends Actor {
    // Normal (idle) palette
    private static final Color NORMAL_BACKGROUND = new Color(10, 15, 30);
    private static final Color NORMAL_BORDER = new Color(0, 255, 255);   // Neon cyan
    private static final Color NORMAL_TEXT = new Color(200, 255, 255);  // Light cyan

    // Hover palette
    private static final Color HOVER_BACKGROUND = new Color(25, 15, 45);
    private static final Color HOVER_BORDER = new Color(255, 0, 128);   // Neon pink/magenta
    private static final Color HOVER_TEXT = new Color(255, 255, 255);   // Crisp white

    private static final String FONT_NAME = "Courier New";

    private final String text;
    private final int width;
    private final int height;
    private boolean isHovered = false;

    public Button(String text, int width, int height) {
        this.text = text;
        this.width = width;
        this.height = height;
        drawButton(false);
    }

    // https://www.greenfoot.org/topics/4548
    private void drawButton(boolean hover) {
        GreenfootImage img = new GreenfootImage(width, height);

        Color background = hover ? HOVER_BACKGROUND : NORMAL_BACKGROUND;
        Color border = hover ? HOVER_BORDER : NORMAL_BORDER;
        Color textColor = hover ? HOVER_TEXT : NORMAL_TEXT;

        img.setColor(background);
        img.fill();

        img.setColor(border);
        img.drawRect(0, 0, width - 1, height - 1);
        img.drawRect(1, 1, width - 3, height - 3);

        img.setColor(textColor);
        drawCenteredText(img);


        setImage(img);
    }

    private void drawCenteredText(GreenfootImage img) {
        img.setFont(new Font(FONT_NAME, true, false, height / 3));

        int textWidth = (int) (text.length() * (height / 5.0));
        int textX = (width - textWidth) / 2;
        int textY = (height / 2) + (height / 8);

        img.drawString(text, textX, textY);
    }

    public void act() {
        checkHover();
        if (!Greenfoot.mouseClicked(this)) return;

        SoundManager.playButtonClick();
        executeAction();
    }

    private void setHoverButton(boolean isHover) {
        isHovered = isHover;
        drawButton(isHover);
    }


    // https://www.greenfoot.org/topics/4029
    private void checkHover() {
        if (Greenfoot.mouseMoved(this) && !isHovered) {
            setHoverButton(true);
            SoundManager.playButtonOver();
        }

        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this) && isHovered) {
            setHoverButton(false);
        }
    }

    public abstract void executeAction();
}