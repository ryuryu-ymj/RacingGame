package racingGame;

import org.newdawn.slick.*;

/**
 * タイトル画面の更新、描画を行うクラス
 *
 * @author ryuryu
 */
public class Title extends GameState
{
    private Font title;
    private Font description;
    private float darkness;

    Title()
    {
        title = new Font("res/font/fontLarge");
        description = new Font("res/font/fontSmall");
    }

    @Override
    public void init(GameContainer gc) throws SlickException
    {
        // TODO 自動生成されたメソッド・スタブ
        darkness = 0;
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException
    {
        // TODO 自動生成されたメソッド・スタブ
        darkness += 0.05;
        if (darkness > 1)
        {
            darkness = 0;
        }

        if(gc.getInput().isKeyPressed(Input.KEY_SPACE))
        {
            nextState = true;
        }
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException
    {
        // TODO 自動生成されたメソッド・スタブ
        title.setColor(0, 0, 0);
        title.drawString("Racing Game", Play.DISPLAY_WIDTH / 2 - title.getWidth("Racing Game") / 2, 400);

        description.setColor(0, 0, 0, darkness);
        description.drawString("push space key", Play.DISPLAY_WIDTH / 2 - description.getWidth("push space key") / 2, 600);
    }
}
