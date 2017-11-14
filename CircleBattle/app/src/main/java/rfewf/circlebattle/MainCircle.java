package rfewf.circlebattle;

import android.graphics.Color;

/**
 * Created by Franck on 13.11.2017.
 */

public class MainCircle extends SimpleCircle {
    static int INTI_RADIUS = 50;
    static int MAIN_SPEED = 30;

    MainCircle(int x, int y) {
        super(x, y, INTI_RADIUS);
        setColor(Color.BLUE);
    }

        void moveMainCircleWhenTouchAt(int x1, int y1) {
                int dx = (x1 - x) * MAIN_SPEED / CanvasView.width;
                int dy = (y1 - y) * MAIN_SPEED / CanvasView.height;
                x += dx;
                y += dy;
    }
}