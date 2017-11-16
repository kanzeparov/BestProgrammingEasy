package rfewf.circlebattle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Franck on 13.11.2017.
 */

class CanvasView extends View implements ICanvasView{
    Paint paint;
    MainCircle mainCircle;
    static int width;
    static int height;
    Canvas canvas;
    static int MAX_CIRCLES = 10;
    ArrayList<EnemyCircle> circles;
    private Toast toast;

    CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initWidthAndHeight(context);
        initMainCircle();
        initEnemyCircles();
        initPaint();
    }

   void initEnemyCircles() {
       SimpleCircle mainCircleArea = mainCircle.getCircleArea();
       circles = new ArrayList<EnemyCircle>();
       for (int i = 0; i < MAX_CIRCLES; i++) {
           EnemyCircle circle;
           do {
               circle = EnemyCircle.getRandomCircle();
           } while (circle.isIntersect(mainCircleArea)); //до тех пор пока не будет пересекаться
           circles.add(circle);
       }
       calculateAndSetCirclesColor();
   }


    void initMainCircle() {
        mainCircle = new MainCircle(width/2, height/2);
    }

    void initPaint() {
        paint = new Paint(); // Создание кисточки
        paint.setAntiAlias(true);//сглаживание
        paint.setStyle(Paint.Style.FILL); //Заполнение кружка цветом
    }

    void initWidthAndHeight(Context context) {
                WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
                Display display = windowManager.getDefaultDisplay();
                Point point = new Point();
                display.getSize(point);
                width = point.x;
                height = point.y;
            }


    @Override
    protected void onDraw(Canvas canvasFromMethod) {
        super.onDraw(canvasFromMethod);
        canvas = canvasFromMethod;
        drawCircle(mainCircle);
        for (EnemyCircle circle : circles) {
            drawCircle(circle);
        }

    }



    void calculateAndSetCirclesColor() {
                for (EnemyCircle circle : circles) {
                    Log.d("mylog", circle.getColor() + "bef");
                        circle.setEnemyOrFoodColorDependsOn(mainCircle);
                    Log.d("mylog", circle.getColor() + "after");
                    }
    }



    @Override
     public boolean onTouchEvent(MotionEvent event) {
                int x = (int) event.getX();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    onTouchEvent(x, y);
                    }
                invalidate();//ОБНОВЛЕНИЕ
                return true;
            }

    void onTouchEvent(int x, int y) {
        mainCircle.moveMainCircleWhenTouchAt(x, y);
                moveCircles();
        checkCollision();
            }
    public void redraw() {
                invalidate();
            }


     void checkCollision() {
         SimpleCircle circleForDel = null;
         for (EnemyCircle circle : circles) {
             if (mainCircle.isIntersect(circle)) {
                                 if (circle.isSmallerThan(mainCircle)) {
                                         mainCircle.growRadius(circle);
                                         circleForDel = circle;
                                         calculateAndSetCirclesColor();
                                         break;
                                     } else {
                                         gameEnd("YOU LOSE!");
                                         return;
                                     }
             }
         }
                 if (circleForDel != null) {
                         circles.remove(circleForDel);
                     }
                 if (circles.isEmpty()) {
                         gameEnd("YOU WIN!");
                     }
     }
      void gameEnd(String text) {
        showMessage(text);
                mainCircle.initRadius();
                initEnemyCircles();
                redraw();
            }

    @Override
     public void showMessage(String text) {
               if (toast != null) {
                        toast.cancel();
                    }
                toast = Toast.makeText(getContext(), text, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
           }

     void moveCircles() {
                for (EnemyCircle circle : circles) {
                        circle.moveOneStep();
                }
    }
    //Для того, чтобы в этот метод подавать и другие круги
    @Override
    public void drawCircle(SimpleCircle circle) {
        paint.setColor(circle.getColor());
        canvas.drawCircle(circle.getX(), circle.getY(), circle.getRadius(), paint);
    }
}
