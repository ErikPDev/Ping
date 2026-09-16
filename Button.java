import greenfoot.*;

public abstract class Button extends Actor {
    private String text;
    private int width;
    private int height;
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

        if (hover) {
            // Hover state: Brighter background, neon magenta/pink glow
            img.setColor(new Color(25, 15, 45));
            img.fill();

            img.setColor(new Color(255, 0, 128)); // Neon Pink/Magenta
            img.drawRect(0, 0, width - 1, height - 1);
            img.drawRect(1, 1, width - 3, height - 3);

            img.setColor(new Color(255, 255, 255)); // Crisp white text
        } else {
            // Normal state: Classic dark space-indigo, cyan glow
            img.setColor(new Color(10, 15, 30));
            img.fill();

            img.setColor(new Color(0, 255, 255)); // Neon Cyan
            img.drawRect(0, 0, width - 1, height - 1);
            img.drawRect(1, 1, width - 3, height - 3);

            img.setColor(new Color(200, 255, 255)); // Light cyan text
        }

        // Render text
        Font spaceFont = new Font("Courier New", true, false, height / 3);
        img.setFont(spaceFont);

        int textWidth = (int) (text.length() * (height / 5));
        int textX = (width - textWidth) / 2;
        int textY = (height / 2) + (height / 8);

        img.drawString(text, textX, textY);
        setImage(img);
    }

    public void act() {
        checkHover();
        if (!Greenfoot.mouseClicked(this)) return;
        executeAction();
    }

    private void setHoverButton(boolean isHover){
        isHovered = isHover;
        drawButton(isHover);
    }

    // https://www.greenfoot.org/topics/4029
    private void checkHover() {
        if (Greenfoot.mouseMoved(this) && !isHovered) setHoverButton(true);

        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this) && isHovered) {
            setHoverButton(false);
        }
    }

    public abstract void executeAction();
}
