package racingGame;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

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

    public void move(GameContainer gc)
    {
    	if(gc.getInput().isKeyDown(Input.KEY_UP)) {
            abY-=1;
    	}
    	if(gc.getInput().isKeyDown(Input.KEY_DOWN)) {
            abY+=1;
    	}
    	if(gc.getInput().isKeyDown(Input.KEY_LEFT)) {
            abX-=1;
    	}
    	if(gc.getInput().isKeyDown(Input.KEY_RIGHT)) {
            abX+=1;
    	}
    }

    @Override
    public void update(GameContainer gc, float cameraX, float cameraY)
    {
        changeToDisplayPoint(cameraX, cameraY);
    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(Color.pink);
        g.fillRect(diX - width / 2, diY - height / 2, width, height);
    }
}
