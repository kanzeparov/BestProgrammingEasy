package rfewf.circlebattle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Franck on 13.11.2017.
 */

public class CanvasView extends View {
    Paint paint;
    MainCircle mainCircle;

    CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initMainCircle();
        initPaint();
    }


    void initMainCircle() {
        mainCircle = new MainCircle(100, 200);
    }

    void initPaint() {
        paint = new Paint(); // Создание кисточки
        paint.setAntiAlias(true);//сглаживание
        paint.setStyle(Paint.Style.FILL); //Заполнение кружка цветом
    }


    @Override
    protected void onDraw(Canvas canvasFromMethod) {
        super.onDraw(canvasFromMethod);
        canvasFromMethod.drawCircle(mainCircle.getX(), mainCircle.getY(), mainCircle.getRadius(), paint);
    }



}
