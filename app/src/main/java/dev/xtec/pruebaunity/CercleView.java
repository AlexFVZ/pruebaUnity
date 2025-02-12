package dev.xtec.pruebaunity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

public class CercleView extends View {

    Context context;
    int posx,posy,ampleView,altView,velocidad,radi;
    boolean direccionX=true,direccionY=true;


    public CercleView(Context context){
        super(context);
    }

    public CercleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void init (){
        posx=100;
        posy=100;
        velocidad=10;
        radi=100;
    }

    @Override
    protected void onSizeChanged(int w,int h,int oldw,int oldh){
        super.onSizeChanged(w,h,oldw,oldh);
        this.ampleView = w;
        this.altView = h;
    }

    @Override
    protected void onDraw(@NotNull Canvas canvas){
        super.onDraw(canvas);

        Paint pincel=new Paint();
        pincel.setColor(Color.RED);
        pincel.setStrokeWidth(8);
        pincel.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(posx,posy,radi,pincel);
    }

    public void mou(){
//        posx=posx+velocidad;
//        posy=posy+velocidad;
        if (posx+radi>ampleView )
        {
            direccionX=false;
            posx=ampleView-radi;
        }
        if (posx-radi<0 )
        {
            direccionX=true;
            posx=radi;
        }
        if(posy+radi>altView)
        {
            direccionY=false;
            posy=altView-radi;
        }
        if (posy-radi<0){
            direccionY=true;
            posy=radi;
        }
        if(direccionX){
            posx=posx+velocidad;
        }
        else{
            posx=posx-velocidad;
        }
        if (direccionY){
            posy=posy+velocidad;
        }
        else {
            posy=posy-velocidad;
        }
    }
}
