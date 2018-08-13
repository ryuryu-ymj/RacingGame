package racingGame;

/**
 * カメラクラス<br>
 * これに合わせて，画面が動く
 *
 * @author ryuryu
 */
public class Camera
{
    /**
     * 画面の中心座標
     */
    float x, y;
    boolean active;

    Camera()
    {
        x = 0;
        y = 0;
        active = true;
    }

    /**
     * 更新処理<br>
     * プレイヤーが中心に来るようになる
     *
     * @param x     カメラのx座標
     * @param y     カメラのy座標
     * @param angle カメラの向き　12時から時計回り　ラジアン
     */
    void update(float x, float y, float angle)
    {
        if (active)
        {
            this.x = x;
            this.y = y;
        }
    }
}
