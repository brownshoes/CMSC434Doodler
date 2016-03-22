package com.example.me.cmsc434doodler;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Me on 3/5/2016.
 */
public class DoodleView extends View {


    private class Data {
        Path storePath;
        int storeColor;
        float storeStroke;
        int storeAlpha;

        Data(Path x, int color, float stroke, int alpha){
            this.storePath = x;
            this.storeColor = color;
            this.storeStroke = stroke;
            this.storeAlpha = alpha;

        }

    }
    private ArrayList<Data> store = new ArrayList<Data>();

    private int element = 0;

    private Paint paintDoodle = new Paint();
    private Path paintPath = new Path();

    //defaults
    private int currentColor = Color.BLACK;
    private float currentStroke = 4;
    private int currentAlpha = 255;

    public DoodleView(Context context) {
        super(context);
        init(null, 0);
    }

    public DoodleView(Context context,AttributeSet attrs ) {
        super(context, attrs);
        init(attrs, 0);
    }

    public DoodleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    private void init(AttributeSet attrs, int defStyleAttr){

        paintDoodle.setStrokeWidth(currentStroke);
        paintDoodle.setAlpha(currentAlpha);

        paintDoodle.setColor(currentColor);
        paintDoodle.setStyle(Paint.Style.STROKE);
    }

    public void changeColor(int color) {

        invalidate();
        currentColor = color;
        paintDoodle.setColor(color);
    }

    public void changeStroke(float stroke){

        invalidate();
        currentStroke = stroke;
        paintDoodle.setStrokeWidth(stroke);
    }

    public void changeAlpha(int alpha){

        invalidate();
        currentAlpha = alpha;
        paintDoodle.setAlpha(alpha);


    }

    public void undo(){

        //store.remove(store.size() - 1);

        if (element > 0){

            element--;
            invalidate();
        }   

    }

    public void redo(){

       if(element < store.size() ){

            element++;
            invalidate();
       }
    }

    public void clear(){

        store.clear();
        element = 0;
        invalidate();
    }
/*
    //size assigned to view
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(canvasBitmap);
    }
*/
    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        //canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);

        //int length = store.size();

        paintDoodle.setStrokeWidth(currentStroke);
        paintDoodle.setColor(currentColor);
        paintDoodle.setAlpha(currentAlpha);

        canvas.drawPath(paintPath, paintDoodle);

        //for(int count = 0; count < length; count++){
        for(int count = 0; count < element; count++){

            Path savePath = store.get(count).storePath;
            int saveColor = store.get(count).storeColor;
            float saveStroke = store.get(count).storeStroke;
            int saveAlpha = store.get(count).storeAlpha;

            paintDoodle.setColor(saveColor);
            paintDoodle.setStrokeWidth(saveStroke);
            paintDoodle.setAlpha(saveAlpha);
            canvas.drawPath(savePath, paintDoodle);

        }


    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent){
        float touchX = motionEvent.getX();
        float touchY = motionEvent.getY();

        switch(motionEvent.getAction()){

            case MotionEvent.ACTION_DOWN:
                paintPath.moveTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                paintPath.lineTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_UP:

                //paintPath.lineTo(touchX, touchY);
                //drawCanvas.drawPath(paintPath, paintDoodle);

                if(element < store.size()) {                    

                    while (store.size() > element){

                        store.remove(element);
                    }

                }

                store.add(new Data(new Path(paintPath), currentColor, currentStroke, currentAlpha));
                element++;
                paintPath.reset();
                break;
        }

        invalidate();
        return true;
    }

}
