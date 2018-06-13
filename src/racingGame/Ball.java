package racingGame;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.Random;

/**
 * ボール <br>
 * サンプルのゲームオブジェクトクラス
 *
 * @author ryuryu
 */
public class Ball extends GameObject
{
    /**
     * 速度ベクトル
     */
    float speedX, speedY;

    Ball()
    {
        abX = 0;
        abY = 0;
        width = 40;
        height = 40;
        active = true;
        Random rnd = new Random();
        speedX = 10 - rnd.nextInt(20);
        speedY = 10 - rnd.nextInt(20);
    }

    @Override
    public void update(GameContainer gc, float cameraX, float cameraY, float cameraAngle)
    {
        speedY += 0.1;

        abX += speedX;
        abY += speedY;
        changeToDisplayPoint(cameraX, cameraY, cameraAngle);
    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(Color.black);
        g.drawOval(diX, diY, width, height);
    }

    public void boundX()
    {
        speedX = -speedX;
    }

    public void boundY()
    {
        speedY = -speedY;
    }
}
