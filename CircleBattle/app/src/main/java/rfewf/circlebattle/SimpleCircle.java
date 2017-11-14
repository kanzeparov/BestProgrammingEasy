package rfewf.circlebattle;

/**
 * Created by Franck on 13.11.2017.
 */

class SimpleCircle {

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
        color = colorFromMethod;
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

    SimpleCircle getCircleArea() {
               return new SimpleCircle(x, y, radius * 3);
           }

             boolean isIntersect(SimpleCircle circle) {
                return radius + circle.radius >= Math.sqrt(Math.pow(x - circle.x, 2) + Math.pow(y - circle.y, 2));
            }
}
