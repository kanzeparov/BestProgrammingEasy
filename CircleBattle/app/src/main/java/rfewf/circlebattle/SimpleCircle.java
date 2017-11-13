package rfewf.circlebattle;

/**
 * Created by Franck on 13.11.2017.
 */

public class SimpleCircle {

    int x;
    int y;
    int radius;
    int color;

    public SimpleCircle(int xFromConstructor, int yFromConstructor, int radiusFromConstructor) {
        x = xFromConstructor;
        y = yFromConstructor;
        radius = radiusFromConstructor;
    }

    void setColor(int colorFromMethod) {
        colorFromMethod = color;
    }
    int getX() { return x; }
    int getY() {
        return y;
    }
    int getRadius() {
        return radius;
    }
    int getColor() {
        return color;
    }
}
