package com.example.andrii.rxprojectlesson.ui.canvas.firstlessons.presentation;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.andrii.rxprojectlesson.R;
import com.example.andrii.rxprojectlesson.app.base.BaseActivity;

public class CanvasFirstLessonsActivity
        extends BaseActivity<CanvasFirstLessonsContract.View, CanvasFirstLessonsContract.Presenter>
        implements CanvasFirstLessonsContract.View {

    public static void start(Context context) {
        Intent intent = new Intent(context, CanvasFirstLessonsActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutResourceID() {
        return R.layout.canvas_first_lessons_activity;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(new DrawViewLesson1(this));
//        setContentView(new DrawViewLesson2(this));
        setContentView(new DrawViewLesson3(this));
    }

    class DrawViewLesson3 extends View {

        Paint linePaint;
        Paint dotPaint;
        Paint linePaint1;
        DashPathEffect dashPath;

        public DrawViewLesson3(Context context) {
            super(context);
            dashPath = new DashPathEffect(new float[]{5, 5}, 1);

            linePaint = new Paint();
            linePaint.setAntiAlias(true);
            linePaint.setARGB(255, 255, 0, 0);
            linePaint.setPathEffect(dashPath);
            linePaint.setStyle(Paint.Style.STROKE);
            linePaint.setStrokeWidth(3.0f);

            dotPaint = new Paint();
            dotPaint.setAntiAlias(true);
            dotPaint.setARGB(255, 255, 0, 0);
            dotPaint.setStyle(Paint.Style.FILL);

            linePaint1 = new Paint();
            linePaint1.setAntiAlias(true);
            linePaint1.setARGB(255, 255, 0, 0);
            linePaint1.setStrokeWidth(3.0f);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawCircle(480, 600, 120, linePaint);
//            canvas.drawCircle(160, 200, 4, dotPaint);

            canvas.drawLine(360, 600, 270, 600, linePaint1); // left
            canvas.drawLine(480, 480, 480, 390, linePaint1); // top
            canvas.drawLine(600, 600, 690, 600, linePaint1); // right
            canvas.drawLine(600, 720, 690, 810, linePaint1);
//            canvas.drawLine(600, 720, 690, 810, linePaint1);

            canvas.drawLine(480, 720, 480, 810, linePaint1); // bottom
        }
    }

    class DrawViewLesson2 extends View {

        Paint paint;
        RectF rectf;
        float[] points;
        float[] points1;

        public DrawViewLesson2(Context context) {
            super(context);
            paint = new Paint();
            rectf = new RectF(700, 100, 800, 150);
            points = new float[]{100, 50, 150, 100, 150, 200, 50, 200, 50, 100};
            points1 = new float[]{300, 200, 600, 200, 300, 300, 600, 300, 400, 100, 400, 400, 500, 100, 500, 400};
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            canvas.drawARGB(80, 102, 204, 255);

            paint.setColor(Color.RED);
            paint.setStrokeWidth(10);

            // рисуем точки их массива points
            canvas.drawPoints(points, paint);

            // рисуем линии по точкам из массива points1
            canvas.drawLines(points1, paint);

            // перенастраиваем кисть на зеленый цвет
            paint.setColor(Color.GREEN);

            // рисуем закругленный прямоугольник по координатам из rectf
            // радиусы закругления = 20
            canvas.drawRoundRect(rectf, 20, 20, paint);

            // смещаем коорднаты rectf на 150 вниз
            rectf.offset(0, 150);

            // рисуем овал внутри прямоугольника rectf
            canvas.drawOval(rectf, paint);

            // смещаем rectf в (900,100) (левая верхняя точка)
            rectf.offsetTo(900, 100);
            //увеличиваем rectf по вертикали на 25 вниз и вверх
            rectf.inset(0, -25);
            // рисуем дугу внутри прямоугольника rectf
            // с началом в 90, и длиной 270
            // соединение крайних точек через центр
            //Начало – угол, с которого дуга начинает рисоваться. Отсчет ведется по часовой стрелке от точки «3 часа»,
            // если рассматривать часовой циферблат. Т.е. если от трех часов отложить угол 90 градусов, получится шесть часов.
            // С этой точки и начнется рисоваться дуга.
            canvas.drawArc(rectf, 90, 270, true, paint);

            // смещаем коорднаты rectf на 150 вниз
            rectf.offset(0, 150);
            // рисуем дугу внутри прямоугольника rectf
            // с началом в 90, и длиной 270
            // соединение крайних точек напрямую
            canvas.drawArc(rectf, 90, 270, false, paint);

            // перенастраиваем кисть на толщину линии = 3
            paint.setStrokeWidth(3);
            // рисуем линию (150,450) - (150,600)
            canvas.drawLine(150, 450, 150, 600, paint);

            // перенастраиваем кисть на синий цвет
            paint.setColor(Color.BLUE);

            // настраиваем размер текста = 30
            paint.setTextSize(30);
            // рисуем текст в точке (150,500)
            canvas.drawText("text left", 150, 500, paint);
        }
    }

    class DrawViewLesson1 extends View {

        Paint paint;
        Rect rect;

        public DrawViewLesson1(Context context) {
            super(context);
            paint = new Paint();
            rect = new Rect();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            // заливка канвы цветом
            canvas.drawARGB(80, 102, 204, 255);

            // настройка кисти
            // красный цвет
            paint.setColor(Color.RED);
            // толщина линии = 10
            paint.setStrokeWidth(10);

            // рисуем точку (50,50)
            canvas.drawPoint(50, 50, paint);

            // рисуем линию от (100,100) до (500,50)
            canvas.drawLine(100, 100, 500, 50, paint);

            // рисуем круг с центром в (100,200), радиус = 50
            canvas.drawCircle(100, 200, 50, paint);

            // рисуем прямоугольник
            // левая верхняя точка (200,150), нижняя правая (400,200)
            canvas.drawRect(200, 150, 400, 200, paint);

            // настройка объекта Rect
            // левая верхняя точка (250,300), нижняя правая (350,500)
            rect.set(250, 300, 350, 500);
            // рисуем прямоугольник из объекта rect
            canvas.drawRect(rect, paint);
        }
    }
}
