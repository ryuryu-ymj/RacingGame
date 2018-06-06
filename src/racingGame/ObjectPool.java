package racingGame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

/**
 * ゲームオブジェクトの管理クラス.
 * オブジェクトのインスタンスを持ち,
 * オブジェクト同士の相互作用(衝突処理など)を一括管理する.
 *
 * @author ryuryu
 */
public class ObjectPool
{
    Ball[] balls = new Ball[5];
    Camera camera;

    ObjectPool()
    {
        for (int i = 0; i < balls.length; i++)
        {
            balls[i] = new Ball();
        }
        camera = new Camera();
        init();
    }

    /**
     * 初期化処理.
     */
    public void init()
    {
    }

    /**
     * ステップごとの更新.
     */
    public void update(GameContainer gc)
    {
        updateObjects(balls, gc);
        camera.update(0, 0);
        //System.out.println(0);
    }

    /**
     * ステップごとの描画処理.
     */
    public void render(Graphics g)
    {
        renderObjects(balls, g);
    }

    /**
     * 衝突判定
     */
    public void collisionDetection()
    {
        // ボールと壁の衝突
        for (int i = 0; i < balls.length; i++)
        {
            if (balls[i].diY >= Play.DISPLAY_HEIGHT)
            {
                balls[i].boundY();
            }
            if (balls[i].diX <= 0 || balls[i].diX >= Play.DISPLAY_WIDTH)
            {
                balls[i].boundX();
            }
        }
    }

    /**
     * 配列内のすべてのインスタンスを無効にする.
     *
     * @param object ゲームオブジェクトの配列
     */
    private void deactivateObjects(GameObject[] object)
    {
        for (GameObject obj : object)
        {
            obj.active = false;
        }
    }

    /**
     * 配列内のインスタンスのうち,有効な物のみを更新する.
     *
     * @param object ゲームオブジェクトの配列
     */
    private void updateObjects(GameObject[] object, GameContainer gc)
    {
        for (GameObject obj : object)
        {
            if (obj.active)
            {
                obj.update(gc, 0, 0);
            }
        }
    }

    /**
     * 配列内のインスタンスのうち,有効な物のみを描画する.
     *
     * @param object ゲームオブジェクトの配列
     */
    private void renderObjects(GameObject[] object, Graphics g)
    {
        for (GameObject obj : object)
        {
            if (obj.active)
            {
                obj.render(g);
            }
        }
    }
}
