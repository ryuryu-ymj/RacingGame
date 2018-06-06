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
     * @param playerX プレイヤーのx座標
     * @param playerY プレイヤーのy座標
     */
    void update(float playerX, float playerY)
    {
        if (active)
        {
            x = playerX;
            y = playerY;
        }
    }
}
