package rfewf.circlebattle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by Franck on 13.11.2017.
 */

public class CanvasView extends View {
    Paint paint;
    MainCircle mainCircle;
    static int width;
    static int height;

    CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initMainCircle();
        initPaint();
        initWidthAndHeight(context);
    }


    void initMainCircle() {
        mainCircle = new MainCircle(100, 200);
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
        canvasFromMethod.drawCircle(mainCircle.getX(), mainCircle.getY(), mainCircle.getRadius(), paint);
    }


    @Override
     public boolean onTouchEvent(MotionEvent event) {
                int x = (int) event.getX();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    mainCircle.moveMainCircleWhenTouchAt(x, y);
                    }
                invalidate();//ОБНОВЛЕНИЕ
                return true;
            }

}
