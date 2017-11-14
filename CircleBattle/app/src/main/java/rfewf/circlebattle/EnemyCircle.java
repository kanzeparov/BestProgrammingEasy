package rfewf.circlebattle;

import android.graphics.Color;
import android.util.Log;

import java.util.Random;

/**
 * Created by Franck on 14.11.2017.
 */

class EnemyCircle extends SimpleCircle {

      static int FROM_RADIUS = 10;
      static final int TO_RADIUS = 110;
      static int ENEMY_COLOR = Color.RED;
      static int FOOD_COLOR = Color.rgb(0, 200, 0);
      static int RANDOM_SPEED = 10;
      int dx;
      int dy;

      EnemyCircle(int x, int y, int radius, int dxFromConstructor, int dyFromConstructor) {
                super(x, y, radius);
                dx = dxFromConstructor;
                dy = dyFromConstructor;
            }

    void setEnemyOrFoodColorDependsOn(MainCircle mainCircle) {
        Log.d("mylog", mainCircle.radius  + "setEn" + radius);
                if (isSmallerThan(mainCircle)) {
                        setColor(FOOD_COLOR);
                    } else {
                        setColor(ENEMY_COLOR);
                    }
            }


     boolean isSmallerThan(SimpleCircle circle) {
                if (radius < circle.radius) {
                        return true;
                    }
                return false;
            }

    static EnemyCircle getRandomCircle() {
                Random random = new Random();
                int x = random.nextInt(CanvasView.width);
                int y = random.nextInt(CanvasView.height);
                int dx = 1 + random.nextInt(RANDOM_SPEED);
                int dy = 1 + random.nextInt(RANDOM_SPEED);
                int radius = FROM_RADIUS + random.nextInt(TO_RADIUS - FROM_RADIUS);
                EnemyCircle enemyCircle = new EnemyCircle(x, y, radius, dx, dy);
                return enemyCircle;
    }


}
