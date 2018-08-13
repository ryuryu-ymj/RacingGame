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
    Camera camera;
    Car car;

    ObjectPool()
    {
        camera = new Camera();
        car = new Car(0, 0);
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
        camera.update(0, 0, (float) Play.counter / 100);
        //System.out.println(camera.angle);
        System.out.println(car.diX + " " + car.diY);
        car.update(gc, camera.x, camera.y);
        car.move(gc);
    }

    /**
     * ステップごとの描画処理.
     */
    public void render(Graphics g)
    {
        car.render(g);
    }

    /**
     * 衝突判定
     */
    public void collisionDetection()
    {
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
                obj.update(gc, camera.x, camera.y);
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
