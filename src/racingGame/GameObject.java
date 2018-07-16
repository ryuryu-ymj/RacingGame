package racingGame;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

/**
 * ゲームオブジェクトの抽象クラス.
 *
 * @author ryuryu
 */
public abstract class GameObject
{
    /**
     * インスタンス有効フラグ(falseならインスタンスは処理されない)
     */
    public boolean active;

    /**
     * 中心点のx座標
     */
    public float abX;

    /**
     * 中心点のy座標
     */
    public float abY;

    /**
     * 横幅
     */
    public float width;

    /**
     * 縦幅
     */
    public float height;

    /**
     * 画面に表示するx座標
     */
    public float diX;

    /**
     * 画面に表示するy座標
     */
    public float diY;

    /**
     * ステップごとの更新.
     *
     * @param cameraX     カメラの中心点のx座標
     * @param cameraY     カメラの中心点のy座標
     * @param cameraAngle カメラの角度　12時から時計回り　ラジアン
     */
    public abstract void update(GameContainer gc, float cameraX, float cameraY, float cameraAngle);

    /**
     * ステップごとの描画処理.
     */
    public abstract void render(Graphics g);

    /**
     * 絶対座標を画面座標に変換する
     *
     * @param cameraX     カメラの中心点のx座標
     * @param cameraY     カメラの中心点のy座標
     * @param cameraAngle カメラの角度　12時から時計回り　ラジアン
     */
    public void changeToDisplayPoint(float cameraX, float cameraY, float cameraAngle)
    {
        double radius = Math.sqrt(Math.pow(abX - cameraX, 2) + Math.pow(abY - cameraY, 2));
        double angle = Math.atan2(abY - cameraY, abX - cameraX) - cameraAngle;
        diX = (float) (radius * Math.cos(angle) + Play.DISPLAY_WIDTH / 2);
        diY = (float) (radius * Math.sin(angle) + Play.DISPLAY_HEIGHT / 2);
    }

    /**
     * オブジェクトがプレイ領域内にいるかどうかを確認し,
     * 領域外に出ている場合は,インスタンスを無効にする.
     *
     * @param mergin 余裕
     */
    boolean checkLeaving(int mergin)
    {
        return (diX < -width / 2 - mergin
                || diX > Play.DISPLAY_WIDTH + width / 2 + mergin
                || diY < -height / 2 - mergin
                || diY > Play.DISPLAY_HEIGHT + height / 2 + mergin);
    }
}