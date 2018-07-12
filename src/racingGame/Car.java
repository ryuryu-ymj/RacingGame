package racingGame;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Car extends GameObject
{
    private float speed;
    private float angle;

    /**
     *
     * @param abX 中心座標
     * @param abY 中心座標
     */
    Car(float abX, float abY)
    {
        this.abX = abX;
        this.abY = abY;
        speed = 0;
        angle = 0;
        width = 30;
        height = 60;
    }

    @Override
    public void update(GameContainer gc, float cameraX, float cameraY, float cameraAngle)
    {
        changeToDisplayPoint(cameraX, cameraY, cameraAngle);
    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(Color.pink);
        g.fillRect(diX - width / 2, diY - height / 2, width, height);
    }
}
