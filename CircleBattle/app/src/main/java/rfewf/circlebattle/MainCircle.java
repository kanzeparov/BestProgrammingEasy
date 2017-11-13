package rfewf.circlebattle;

import android.graphics.Color;

/**
 * Created by Franck on 13.11.2017.
 */

public class MainCircle extends SimpleCircle {
    static int INTI_RADIUS = 50;

    public MainCircle(int x, int y) {
        super(x, y, INTI_RADIUS);
        setColor(Color.BLACK);
    }
}