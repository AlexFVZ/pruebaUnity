package dev.xtec.pruebaunity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

public class ExempleView extends View {
    public boolean cercleblau = true;
    Drawable drawableNau;
    GraficNau nau;

    public int ampleView = 0;
    public int altView = 0;

    public ExempleView(Context context){
        super(context);
    }

    public ExempleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        drawableNau = context.getResources().getDrawable(R.drawable.nau,context.getTheme());
        nau = new GraficNau(this,drawableNau);
    }

    protected void onSizeChanged(int ample, int alt,int ample_anter, int alt_anter) {
        super.onSizeChanged(ample, alt, ample_anter, alt_anter);

        // Obtenim l'ample i l'altçada de la vista amb la que anem a treballar
        this.ampleView = ample;
        this.altView = alt;

        // Ara que sabem la mida de la vista anem a posicionar la Nau
        this.nau.setPosX(this.ampleView / 2);
        this.nau.setPosY(this.altView - 100);
    }

    private void pintarCercleVerd(Canvas canvas){
        int x=130;
        int y=150;
        int width=150;
        int height=300;
        Paint pincel = new Paint();
        pincel.setColor(Color.GREEN);
        pincel.setStrokeWidth(8);
        pincel.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(300, 300, 50, pincel);
    }
    private void pintarCercleBlau(Canvas canvas){
        Paint pincel = new Paint();
        pincel.setColor(Color.BLUE);
        pincel.setStrokeWidth(8);
        pincel.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(100, 100, 50, pincel);
    }


    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        if(cercleblau) pintarCercleBlau(canvas);
        else  pintarCercleVerd(canvas);

        this.nau.dibuixaGrafic(canvas);
    }
}
